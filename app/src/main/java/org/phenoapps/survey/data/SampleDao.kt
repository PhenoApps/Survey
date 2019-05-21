package org.phenoapps.survey.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SampleDao {
    @Query("SELECT * FROM samples WHERE :eid = eid")
    fun getAll(eid: Int): LiveData<List<Sample>>

    @Query("SELECT * from samples WHERE :eid = eid and plot = :plot")
    fun getPlot(eid: Int, plot: String): LiveData<List<Sample>>

    @Query("SELECT plot from samples WHERE :eid = eid")
    fun getPlotNames(eid: Int): LiveData<List<String>>

    @Update
    fun updateSamples(vararg s: Sample): Int

    @Insert
    fun insert(s: Sample): Long

    @Delete
    fun delete(vararg s: Sample): Int
}