package org.phenoapps.survey.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import org.phenoapps.survey.data.Sample

class SampleViewModel(sample: Sample
) : ViewModel() {
    val name = ObservableField<String>(sample.name)
    val lat = ObservableField<Double>(sample.latitude)
    val lng = ObservableField<Double>(sample.longitude)
    val person = ObservableField<String>(sample.person)
}