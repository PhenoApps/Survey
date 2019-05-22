package org.phenoapps.survey.fragments

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.os.Build
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import org.phenoapps.survey.NmeaParser
import org.phenoapps.survey.R
import org.phenoapps.survey.adapters.SampleAdapter
import org.phenoapps.survey.data.Experiment
import org.phenoapps.survey.data.ExperimentRepository
import org.phenoapps.survey.data.SampleRepository
import org.phenoapps.survey.data.SurveyDatabase
import org.phenoapps.survey.databinding.FragmentListSampleBinding
import org.phenoapps.survey.viewmodels.SampleListViewModel
import org.phenoapps.survey.viewmodels.SurveyDataViewModel
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream


class SampleListFragment: Fragment() {

    private val mFirebaseAnalytics by lazy {
        FirebaseAnalytics.getInstance(requireContext())
    }
    //this object contains an array of sample models including sample name, person, and experiment id
    private lateinit var mViewModel: SampleListViewModel

    //a data binding class that contains the layout views
    private lateinit var mBinding: FragmentListSampleBinding

    private lateinit var mExperiment: Experiment

    private lateinit var mBluetoothAdapter: BluetoothAdapter
    private lateinit var mBluetoothDevice: BluetoothDevice
    private lateinit var mBroadcastManager: LocalBroadcastManager
    private lateinit var mConnectedThread: ConnectedThread

    private var parser = NmeaParser()

    private lateinit var mAdapter: SampleAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)

        parser = NmeaParser()

        mExperiment = SampleListFragmentArgs.fromBundle(arguments!!).experiment

        mBinding = FragmentListSampleBinding.inflate(inflater, container, false)

        mAdapter = SampleAdapter(mBinding.root.context)

        mBinding.recyclerView.adapter = mAdapter

        ViewModelProviders.of(this,
                object : ViewModelProvider.NewInstanceFactory() {
                    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                        return SurveyDataViewModel(requireContext()) as T
                    }
                }).get(SurveyDataViewModel::class.java).apply {
            data.observe(viewLifecycleOwner,
                    Observer { data ->
                        if ((data.nmea ?: "").isNotBlank()
                                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            try {
                                parser.parse(data.nmea ?: "")
                                mBinding.latTextView.text = parser.latitude
                                mBinding.lngTextView.text = parser.longitude
                                mBinding.accTextView.text = parser.fix
                                mBinding.spdTextView.text = parser.speed
                                mBinding.utcTextView.text = parser.utc
                                mBinding.brgTextView.text = parser.bearing
                                if (parser.satellites.isEmpty()) {
                                    mBinding.satTextView.text = "${parser.gsv.size}"
                                } else {
                                    val maxSats = maxOf(parser.satellites.toInt(), parser.gsv.size)
                                    mBinding.satTextView.text = "${parser.gsv.size}/$maxSats"
                                }
                                mBinding.altTextView.text = parser.altitude
                            } catch (e: Exception) {
                                mFirebaseAnalytics.logEvent("PARSERERROR", Bundle().apply {
                                    putString("ERROR", e.stackTrace.toString())
                                })
                            }
                        } else {
                            mBinding.latTextView.text = data.lat.toString()
                            mBinding.lngTextView.text = data.lng.toString()
                            mBinding.accTextView.text = "GPS or Net"
                        }
                    })
        }

        mViewModel = ViewModelProviders.of(this,
                object : ViewModelProvider.NewInstanceFactory() {

                    @Suppress("UNCHECKED_CAST")
                    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                        return SampleListViewModel(mExperiment.id, SampleRepository.getInstance(
                                SurveyDatabase.getInstance(requireContext()).sampleDao()),
                                ExperimentRepository.getInstance(SurveyDatabase.getInstance(requireContext()).experimentDao())) as T
                    }
                }).get(SampleListViewModel::class.java)

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                val newList = mAdapter.currentList.toMutableList()
                newList.removeAt(viewHolder.adapterPosition)

                mViewModel.delete(mAdapter.currentList[viewHolder.adapterPosition])

                mAdapter.submitList(newList)
            }
        }).attachToRecyclerView(mBinding.recyclerView)

        mViewModel.samples.observe(viewLifecycleOwner, Observer { samples ->
            samples.let {
                mAdapter.submitList(samples.asReversed())
            }
        })

        mBinding.submitSample.setOnClickListener {

            val value = mBinding.sampleEditText.text.toString()
            if (value.isNotEmpty() && mBinding.latTextView.text.isNotBlank()
                    && mBinding.lngTextView.text.isNotBlank()) {
                //TODO ADD PERSON

                mViewModel.addSample(mExperiment, value, mBinding.latTextView.text.toString().toDouble(),
                        mBinding.lngTextView.text.toString().toDouble(), "CHANEY")
                Snackbar.make(mBinding.root,
                        "New sample $value added.", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(mBinding.root,
                        "You must enter a sample name.", Snackbar.LENGTH_LONG).show()
            }

        }

        return mBinding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_map_locations -> {
                findNavController().navigate(
                        SampleListFragmentDirections.actionMapLocations(mExperiment))
                true
            }
            R.id.action_connect_bluetooth -> {
                findPairedBTDevice()
                true
            }
            else -> item.onNavDestinationSelected(findNavController())
                    || super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.activity_main_toolbar, menu)
    }

    private fun findPairedBTDevice() {

        if (mBluetoothAdapter != null) {

            val pairedDevices = mBluetoothAdapter.getBondedDevices()
            if (!pairedDevices.isEmpty()) {
                val bluetoothMap = HashMap<String, BluetoothDevice>()
                val bluetoothDevicesAdapter = ArrayAdapter<String>(requireContext(), R.layout.row)
                for (bd in pairedDevices) {
                    bluetoothMap.put(bd.getName(), bd)
                    bluetoothDevicesAdapter.add(bd.getName())
                }

                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Choose your paired bluetooth device.")
                val devices = ListView(requireContext())
                devices.setChoiceMode(ListView.CHOICE_MODE_SINGLE)
                //devices.setSelector(R.drawable.list_selector_focus)
                devices.setAdapter(bluetoothDevicesAdapter)
                builder.setView(devices)
                builder.setPositiveButton("OK") { dialog, which ->
                    if (devices.getCheckedItemCount() > 0) {
                        val value = bluetoothDevicesAdapter.getItem(devices.getCheckedItemPosition())
                        if (value != null) {
                            mBluetoothDevice = bluetoothMap.get(value)!!
                            ConnectThread(mBluetoothDevice).start()
                        }
                    }
                }

                builder.show()
            }
        }

    }

    private inner class ConnectThread internal constructor(device: BluetoothDevice) : Thread() {

        private val mmSocket: BluetoothSocket?

        init {
            // Use a temporary object that is later assigned to mmSocket
            // because mmSocket is final.
            var tmp: BluetoothSocket? = null
            mBluetoothDevice = device

            try {
                tmp = device.createRfcommSocketToServiceRecord(device.uuids[0].uuid)
            } catch (e: IOException) {
                Log.e("CONNECT THREAD", "Socket's create() method failed", e)
            }

            mmSocket = tmp
        }

        override fun run() {

            try {
                // Connect to the remote device through the socket. This call blocks
                // until it succeeds or throws an exception.
                mmSocket!!.connect()
            } catch (connectException: IOException) {
                // Unable to connect; close the socket and return.
                try {
                    mmSocket!!.close()
                } catch (closeException: IOException) {
                    Log.e("CONNECT THREAD: RUN", "Could not close the client socket", closeException)
                }

                return
            }

            // The connection attempt succeeded. Perform work associated with
            // the connection in a separate thread.
           // if (mConnectedThread != null && (mConnectedThread.isAlive()
             //               || mConnectedThread.isDaemon() || mConnectedThread.isInterrupted()))
                //mConnectedThread.cancel()
            mConnectedThread = ConnectedThread(mmSocket)
            mConnectedThread.start()

        }

        // Closes the client socket and causes the thread to finish.
        fun cancel() {
            try {
                mmSocket!!.close()
            } catch (e: IOException) {
                Log.e("CONNECT THREAD : CANCEL", "Could not close the client socket", e)
            }

        }
    }

    private class ConnectedThread internal constructor(val socket: BluetoothSocket): Thread() {

        private lateinit var mmInStream: InputStream
        private lateinit var mmOutStream: OutputStream
        private lateinit var mmBuffer: ByteArray

        init {
            try {
                mmInStream = socket.inputStream
                mmOutStream = socket.outputStream
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        override fun run() {

            mmBuffer = ByteArray(256)
            var bytes = 0
            while (true) {
                try {
                    mmBuffer[bytes] = mmInStream.read().toByte()
                    if (bytes > 1 && String(mmBuffer, bytes-1, bytes) == "\r\n") {
                        val msg = String(mmBuffer, 0, bytes-1)
                        Log.d("TEST", msg)
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }


}