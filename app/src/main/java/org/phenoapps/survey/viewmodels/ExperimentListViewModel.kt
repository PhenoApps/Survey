package org.phenoapps.survey.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.phenoapps.survey.data.Experiment
import org.phenoapps.survey.data.ExperimentRepository

class ExperimentListViewModel internal constructor(
        private val repo: ExperimentRepository
) : ViewModel() {

    private val viewModelJob = Job()

    //coroutines do not complete until all launched children complete
    private val viewModelScope = CoroutineScope(Main + viewModelJob)

    val experiments: LiveData<List<Experiment>> = repo.getAll()

    fun addExperiment(experimentId: String, date: String) {
        viewModelScope.launch {
            repo.createExperiment(experimentId, date)
        }
    }

    fun deleteExperiment(experimentId: Experiment) {
        viewModelScope.launch {
            repo.delete(experimentId)
        }
    }
}