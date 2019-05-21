package edu.ksu.wheatgenetics.survey.data

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class ExperimentRepository private constructor(
        private val experimentDao: ExperimentDao
) {
    suspend fun createExperiment(experimentId: String, d: String) {
        withContext(IO) {
            val e = Experiment(experimentId)
            e.date = d
            experimentDao.insert(e)
        }
    }

    suspend fun update(vararg e: Experiment?) {
        withContext(IO) {
            experimentDao.update(*e)
        }
    }

    suspend fun delete(vararg e: Experiment?) {
        withContext(IO) {
            experimentDao.delete(*e)
        }
    }

    fun getAll() = experimentDao.getAll()

    companion object {
        @Volatile private var instance: ExperimentRepository? = null

        fun getInstance(experimentDao: ExperimentDao) =
                instance ?: synchronized(this) {
                    instance ?: ExperimentRepository(experimentDao)
                        .also { instance = it }
                }
    }
}