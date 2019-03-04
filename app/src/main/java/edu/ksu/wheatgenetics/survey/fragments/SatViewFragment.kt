package edu.ksu.wheatgenetics.survey.fragments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.hardware.*
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import edu.ksu.wheatgenetics.survey.GeoNavService
import edu.ksu.wheatgenetics.survey.NmeaParser
import edu.ksu.wheatgenetics.survey.databinding.FragmentSatellitePlotBinding
import kotlin.concurrent.fixedRateTimer

class SatViewFragment: Fragment(), SensorEventListener {

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            System.arraycopy(event.values, 0, accelerometerReading, 0, accelerometerReading.size)
        } else if (event.sensor.type == Sensor.TYPE_MAGNETIC_FIELD) {
            System.arraycopy(event.values, 0, magnetometerReading, 0, magnetometerReading.size)
        }
    }

    private val accelerometerReading = FloatArray(3)
    private val magnetometerReading = FloatArray(3)

    private val rotationMatrix = FloatArray(9)
    private val orientationAngles = FloatArray(3)

    //a data binding class that contains the layout views
    private lateinit var mBinding: FragmentSatellitePlotBinding

    private lateinit var sensorManager: SensorManager
    private lateinit var sensor: Sensor

    private var parser = NmeaParser()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        sensorManager = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR)

        val lbm = LocalBroadcastManager.getInstance(requireContext()).apply {
            registerReceiver(object : BroadcastReceiver() {

                override fun onReceive(context: Context, intent: Intent) {

                    if (intent.hasExtra(GeoNavService.GNSS_EXTRA)) {
                        parser.parse(intent
                                .getStringExtra(GeoNavService.BROADCAST_NMEA))
                        /*Log.d("NMEA", intent
                                .getStringExtra(GeoNavService.PLOT_ID))*/

                    }
                }
            }, GeoNavService.filter)
        }

        fixedRateTimer("GNSSUpdates", false, 0, 75) {
            handler.obtainMessage().sendToTarget()
        }


        mBinding = FragmentSatellitePlotBinding.inflate(inflater, container, false)

        return mBinding.root
    }

    override fun onResume() {
        super.onResume()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

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

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    private val handler = Handler {

        mBinding.graph.subscribe(parser.gsv)

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
        true
    }
}