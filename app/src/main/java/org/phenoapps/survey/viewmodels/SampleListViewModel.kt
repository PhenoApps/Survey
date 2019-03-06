package org.phenoapps.survey.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.phenoapps.survey.data.Experiment
import org.phenoapps.survey.data.ExperimentRepository
import org.phenoapps.survey.data.Sample
import org.phenoapps.survey.data.SampleRepository
import kotlinx.coroutines.*

class SampleListViewModel internal constructor(
        private val eid: Int,
        private val repo: SampleRepository,
        private val expRepo: ExperimentRepository
) : ViewModel() {

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val samples: LiveData<List<Sample>> = repo.getAll(eid)

    val experiments = expRepo.getAll()

    val plotNames: LiveData<List<String>> = repo.getPlotNames(eid)

    fun plots(plot: String) = repo.getPlot(eid, plot)

    fun addSample(e: Experiment, name: String, lat: Double,
                  lng: Double, person: String, plot: String = "") {
        viewModelScope.async {
            repo.createSample(e.id, name, lat, lng, person, plot)
            expRepo.update(e.apply { count += 1 })
        }
    }

    fun update(vararg s: Sample) {
        viewModelScope.launch {
            repo.updateSamples(*s)
        }
    }
}