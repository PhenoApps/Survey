package org.phenoapps.survey.fragments

import android.content.Context
import android.hardware.*
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.analytics.FirebaseAnalytics
import org.phenoapps.survey.NmeaParser
import org.phenoapps.survey.databinding.FragmentSatellitePlotBinding
import org.phenoapps.survey.viewmodels.SurveyDataViewModel

class SatViewFragment: Fragment(), SensorEventListener {

    private val mFirebaseAnalytics by lazy {
        FirebaseAnalytics.getInstance(requireContext())
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            System.arraycopy(event.values, 0, accelerometerReading, 0, accelerometerReading.size)
        } else if (event.sensor.type == Sensor.TYPE_MAGNETIC_FIELD) {
            System.arraycopy(event.values, 0, magnetometerReading, 0, magnetometerReading.size)
        }
        rotateView()
    }

    private val accelerometerReading = FloatArray(3)
    private val magnetometerReading = FloatArray(3)

    private val rotationMatrix = FloatArray(9)
    private val orientationAngles = FloatArray(3)

    //a data binding class that contains the layout views
    private lateinit var mBinding: FragmentSatellitePlotBinding

    private lateinit var sensorManager: SensorManager

    private var parser = NmeaParser()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        ViewModelProviders.of(this,
                object : ViewModelProvider.NewInstanceFactory() {
                    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                        return SurveyDataViewModel(requireContext()) as T
                    }
                }).get(SurveyDataViewModel::class.java).apply {
            data.observe(viewLifecycleOwner,
                    Observer { data ->
                        data.nmea?.let {
                            try {
                                parser.parse(it)
                                mBinding.graph.subscribe(parser.gsv)

                            } catch (e: Exception) {
                                mFirebaseAnalytics.logEvent("PARSERERROR", Bundle().apply {
                                    putString("ERROR", e.stackTrace.toString())
                                })
                            }
                        }
                    })
        }

        mBinding = FragmentSatellitePlotBinding.inflate(inflater, container, false)

        return mBinding.root
    }

    override fun onResume() {
        super.onResume()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            sensorManager = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager

            arrayOf(Sensor.TYPE_ACCELEROMETER, Sensor.TYPE_MAGNETIC_FIELD).forEach { type ->
                sensorManager.getDefaultSensor(type)?.also {
                    sensorManager.registerListener(
                            this,
                            it, SensorManager.SENSOR_DELAY_NORMAL,
                            SensorManager.SENSOR_DELAY_UI
                    )
                }
            }
        }
    }

    fun rotateView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            SensorManager.getRotationMatrix(
                    rotationMatrix,
                    null,
                    accelerometerReading,
                    magnetometerReading
            )

            SensorManager.getOrientation(rotationMatrix, orientationAngles)

            mBinding.graph.rotation = -90f - orientationAngles[0] * (180f / Math.PI).toFloat()
        }
    }

    override fun onPause() {
        super.onPause()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            sensorManager.unregisterListener(this)
        }
    }
}