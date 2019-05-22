package org.phenoapps.survey.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SampleRepository private constructor(
        private val sampleDao: SampleDao
) {
    suspend fun createSample(eid: Int, sampleName: String, lat: Double,
                             lng: Double, person: String, plot: String, date: String) {
        withContext(Dispatchers.IO) {
            sampleDao.insert(Sample(eid, sampleName, lat, lng, person, plot, date))
        }
    }

    suspend fun updateSamples(vararg s: Sample) {
        withContext(Dispatchers.IO) {
            sampleDao.updateSamples(*s)
        }
    }

    suspend fun delete(vararg s: Sample) {
        withContext(Dispatchers.IO) {
            sampleDao.delete(*s)
        }
    }
    fun getPlot(eid: Int, plot: String) = sampleDao.getPlot(eid, plot)

    fun getPlotNames(eid: Int) = sampleDao.getPlotNames(eid)

    fun getAll(eid: Int) = sampleDao.getAll(eid)

    fun getAll() = sampleDao.getAll()

    companion object {
        @Volatile private var instance: SampleRepository? = null

        fun getInstance(sampleDao: SampleDao) =
                instance ?: synchronized(this) {
                    instance ?: SampleRepository(sampleDao)
                            .also { instance = it }
                }
    }
}