package edu.ksu.wheatgenetics.survey

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.location.GnssMeasurement
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.util.Pair
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager


class GeoNavService : Service() {

    private var mMaxAccuracy: Float = java.lang.Float.MAX_VALUE
    private var mMinDist: Float = java.lang.Float.MIN_VALUE
    private var mMinTime: Long = java.lang.Long.MIN_VALUE

    private val mLocationListener: AccurateLocationListener by lazy {
        AccurateLocationListener()
    }

    private val mLocManager: LocationManager by lazy {
        this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    override fun onCreate() {

        super.onCreate()

        if (ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mLocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    mMinTime, mMinDist, mLocationListener)
            mLocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                    mMinTime, mMinDist, mLocationListener)

            //GNSS updates are only available to version >= 24
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                mLocManager.addNmeaListener { s: String?, l: Long ->
                        broadcast(s)
                }
            }
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            val channel = "edu.ksu.wheatgenetics.survey"
            val notification = NotificationCompat.Builder(this, channel)
                    .setSmallIcon(R.drawable.ic_satellite_variant)
                    .setContentTitle("Survey")
                    .setContentText("Survey GPS Running").build()
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                val nc = NotificationChannel(channel,
                        "Channel for Survey Lat/Lng Coordinates",
                        NotificationManager.IMPORTANCE_LOW).apply {
                    enableVibration(false)
                }
                (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
                        .createNotificationChannel(nc)
            }
            startForeground(2, notification)
        } else startForeground(1, Notification())

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    //function to pass data to activities listening to this service
    private fun <T> broadcast(data: T) {
        LocalBroadcastManager.getInstance(this)
            .sendBroadcast(when (data) {
                is DoubleArray -> Intent(BROADCAST_LOCATION).apply {
                    putExtra(LOCATION_EXTRA, data)
                }
                is String -> Intent(BROADCAST_NMEA).apply {
                    putExtra(GNSS_EXTRA, data)
                }
                else -> Intent()
            })
    }

    private inner class AccurateLocationListener : LocationListener {

        override fun onLocationChanged(location: Location) {

            //check if accuracy is below the maximum requested accuracy
            if (location.hasAccuracy() && location.accuracy <= mMaxAccuracy) {
                broadcast(doubleArrayOf(location.latitude, location.longitude))
            }
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {

        }

        override fun onProviderEnabled(provider: String) {

        }

        override fun onProviderDisabled(provider: String) {

        }
    }

    internal companion object {

        val BROADCAST_LOCATION = "edu.ksu.wheatgenetics.survey.BROADCAST_LOCATION"

        val BROADCAST_NMEA = "edu.ksu.wheatgenetics.survey.BROADCAST_NMEA"

        val LOCATION_EXTRA = "edu.ksu.wheatgenetics.survey.LOCATION_EXTRA"

        val GNSS_EXTRA = "edu.ksu.wheatgenetics.survey.LATLNG_EXTRA"

        val filter = IntentFilter().apply {
            //addAction(SurveyActivity.BROADCAST_BT_OUTPUT)
            addAction(GeoNavService.BROADCAST_LOCATION)
            addAction(GeoNavService.BROADCAST_NMEA)
        }
    }
}
