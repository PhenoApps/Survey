package org.phenoapps.survey.fragments

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaScannerConnection
import android.media.MediaScannerConnection.scanFile
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import org.phenoapps.survey.NmeaParser
import org.phenoapps.survey.adapters.ExperimentAdapter
import org.phenoapps.survey.data.*
import org.phenoapps.survey.databinding.FragmentExportBinding
import org.phenoapps.survey.databinding.FragmentSatellitePlotBinding
import org.phenoapps.survey.viewmodels.SurveyDataViewModel
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import kotlin.math.exp

class ExportFragment: Fragment() {

    private lateinit var mBinding: FragmentExportBinding

    private val mFirebaseAnalytics by lazy {
        FirebaseAnalytics.getInstance(requireContext())
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val lineSeparator = System.getProperty("line.separator")

        //get samples and experiment repositories
        val db = SurveyDatabase.getInstance(requireContext())
        val experiments = ExperimentRepository.getInstance(db.experimentDao())
        val samples = SampleRepository.getInstance(db.sampleDao())

        mBinding = FragmentExportBinding.inflate(inflater, container, false)

        //val adapter = ExperimentAdapter(mBinding.root.context)

        //mBinding.recyclerView.adapter = adapter

        mBinding.exportButton.setOnClickListener {
            val value = mBinding.exportEditText.text.toString()
            if (value.isNotEmpty()) {
                samples.getAll().observe(viewLifecycleOwner, Observer { result ->
                    if (result != null && result.isNotEmpty()) {
                        writeFile(value, result)
                    }
                })

            } else {
                Snackbar.make(mBinding.root, "You must choose a filename.", Snackbar.LENGTH_SHORT).show()
            }
        }

        return mBinding.root
    }

    private fun writeFile(value: String, samples: List<Sample>) {
        val lineSeparator = System.getProperty("line.separator")

        try {
            val dir = File(Environment.getExternalStorageDirectory().path + "/Survey")
            dir.mkdir()
            val output = File(dir, "$value.csv")
            val fstream = FileOutputStream(output)

            samples.forEachIndexed { i, s ->
                //TODO ask Trevor for export columns
                fstream.write("${s.eid},${s.id},${s.name},${s.date},${s.latitude},${s.longitude}".toByteArray())
                fstream.write(lineSeparator?.toByteArray())
            }
            scanFile(requireContext(), output)
            fstream.flush()
            fstream.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (io: IOException) {
            io.printStackTrace()
        } finally {
            Snackbar.make(mBinding.root, "File write successful!", Snackbar.LENGTH_SHORT).show()
        }
    }

    fun scanFile(ctx: Context, filePath: File) {
        MediaScannerConnection.scanFile(ctx, arrayOf(filePath.absolutePath), null, null)
    }
}