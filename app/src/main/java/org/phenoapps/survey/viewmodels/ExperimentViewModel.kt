package org.phenoapps.survey.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import org.phenoapps.survey.data.Experiment

class ExperimentViewModel(experiment: Experiment) : ViewModel() {
    val name = ObservableField<String>(experiment.name)
    val count = ObservableField<Int>(experiment.count)
}