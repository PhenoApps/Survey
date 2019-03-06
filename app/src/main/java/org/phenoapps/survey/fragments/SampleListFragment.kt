package org.phenoapps.survey.fragments

import android.os.Build
import android.os.Bundle
import android.text.InputType
import android.view.*
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
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

class SampleListFragment: Fragment() {

    private val mFirebaseAnalytics by lazy {
        FirebaseAnalytics.getInstance(requireContext())
    }
    //this object contains an array of sample models including sample name, person, and experiment id
    private lateinit var mViewModel: SampleListViewModel

    //a data binding class that contains the layout views
    private lateinit var mBinding: FragmentListSampleBinding

    private lateinit var mExperiment: Experiment

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

        mBinding = org.phenoapps.survey.databinding.FragmentListSampleBinding
                .inflate(inflater, container, false)

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
                if ((data.nmea ?: "").isNotBlank() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
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

        mViewModel.samples.observe(viewLifecycleOwner, Observer {samples ->
            samples.let {
                mAdapter.submitList(samples.asReversed())
            }
        })

        mBinding.submitSample.setOnClickListener {
            val input = EditText(requireContext()).apply {
                inputType = InputType.TYPE_CLASS_TEXT
                hint = "Sample"
            }

            val builder = AlertDialog.Builder(requireContext()).apply {

                setView(input)

                setPositiveButton("OK") { _, _ ->
                    val value = input.text.toString()
                    if (value.isNotEmpty() && mBinding.latTextView.text.isNotBlank()
                            && mBinding.lngTextView.text.isNotBlank()) {
                        //TODO ADD PERSON

                        mViewModel.addSample(mExperiment, value, mBinding.latTextView.text.toString().toDouble(),
                                mBinding.lngTextView.text.toString().toDouble(), "CHANEY")
                        Snackbar.make(it,
                                "New sample $value added.", Snackbar.LENGTH_SHORT).show()
                    } else {
                        Snackbar.make(it,
                                "You must enter a sample name.", Snackbar.LENGTH_LONG).show()
                    }
                }
                setTitle("Enter a new experiment name")
            }
            builder.show()
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
            else -> item.onNavDestinationSelected(findNavController())
                    || super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.activity_main_toolbar, menu)
    }
}