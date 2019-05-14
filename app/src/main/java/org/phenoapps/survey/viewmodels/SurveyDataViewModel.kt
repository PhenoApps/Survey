package org.phenoapps.survey.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import org.phenoapps.survey.data.SurveyLiveData

class SurveyDataViewModel(context: Context) : ViewModel() {
    internal val data: SurveyLiveData =
            SurveyLiveData(context)
}