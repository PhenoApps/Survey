package edu.ksu.wheatgenetics.survey.data

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.lifecycle.LiveData
import java.util.*
import kotlin.concurrent.fixedRateTimer


internal class SurveyLiveData(val context: Context) : LiveData<SurveyData>(), LocationListener {

    private val surveyData by lazy { SurveyData() }

    private var mMaxAccuracy: Float = java.lang.Float.MAX_VALUE
    private var mMinDist: Float = java.lang.Float.MIN_VALUE
    private var mMinTime: Long = java.lang.Long.MIN_VALUE

    private val mLocManager: LocationManager by lazy {
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    init {
        if (ActivityCompat.checkSelfPermission(context,
                        Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            mLocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    mMinTime, mMinDist, this)
            mLocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                    mMinTime, mMinDist, this)

            //GNSS updates are only available to version >= 24
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                mLocManager.addNmeaListener { s: String, l: Long ->
                    surveyData.nmea = s
                    postValue(surveyData)
                }
            }
        }
    }

    override fun onLocationChanged(location: Location) {

        surveyData.lat = location.latitude
        surveyData.lng = location.longitude
        postValue(surveyData)

    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(p0: String?) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderDisabled(p0: String?) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}