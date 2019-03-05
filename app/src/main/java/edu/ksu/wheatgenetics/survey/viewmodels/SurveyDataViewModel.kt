package edu.ksu.wheatgenetics.survey.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.ksu.wheatgenetics.survey.data.SurveyLiveData

class SurveyDataViewModel(context: Context) : ViewModel() {
    internal val data: SurveyLiveData =
            SurveyLiveData(context)
}