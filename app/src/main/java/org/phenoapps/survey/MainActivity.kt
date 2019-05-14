package org.phenoapps.survey

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.*
import com.google.firebase.analytics.FirebaseAnalytics
import org.phenoapps.survey.databinding.ActivityMainBinding
import java.io.File

//The purpose of this class is to allow the user to choose an experiment ID to continue/start surveying on
//Experiment Activity
//Using the 'One-Activity' philosophy, this activity controls all the global
//destinations s.a toolbar events and drawer navigation
//Fragments opened through the drawer will have this activity's fragment as a parent.
class MainActivity : AppCompatActivity() {

    private val mFirebaseAnalytics by lazy {
        FirebaseAnalytics.getInstance(this)
    }

    private lateinit var mBinding: ActivityMainBinding

    private val navControl by lazy {
        Navigation.findNavController(this, R.id.experiment_nav_fragment)
    }

    private val appBarConfig by lazy {
        AppBarConfiguration(navControl.graph, mBinding.drawerLayout)
    }

    //location to save Survey data s.a exporting lat/lng .csv
    private lateinit var mSurveyDirectory: File

    private fun isExternalStorageWritable(): Boolean  {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                return Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()
            } else {
                ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), REQ_EXT_STORAGE)
            }
        } else
            return Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()

        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN,
                Bundle().apply {
                    putString(FirebaseAnalytics.Param.TERM, "HELLO")
                })

        mBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main)

        setSupportActionBar(mBinding.toolbar)

        setupActionBarWithNavController(navControl, appBarConfig)

        mBinding.nvView.setupWithNavController(navControl)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE), REQ_FINE_LOCATION)
        }

        /*TODO check external storage permissions when exporting file
        if (isExternalStorageWritable()) {
            mSurveyDirectory = File(Environment.getExternalStorageDirectory().path + "/Survey")
            if (!mSurveyDirectory.isDirectory) {
                mSurveyDirectory.mkdirs()
            }
        }*/
    }

    override fun onRequestPermissionsResult(resultCode: Int, permissions: Array<String>, granted: IntArray) {
        permissions.forEachIndexed { index, perm ->
            when {
                perm == Manifest.permission.ACCESS_FINE_LOCATION
                        && granted[index] == PackageManager.PERMISSION_GRANTED -> {
                }
                perm == Manifest.permission.WRITE_EXTERNAL_STORAGE
                        && granted[index] == PackageManager.PERMISSION_GRANTED -> {

                }
            }
        }
    }

    override fun onSupportNavigateUp() =
        navControl.navigateUp(appBarConfig) ||
                super.onSupportNavigateUp()

    internal companion object {
        const val packageName = "org.phenoapps.survey"

        //requests
        const val REQ_EXT_STORAGE = 101
        const val REQ_FINE_LOCATION = 102
    }

}
