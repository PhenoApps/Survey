package edu.ksu.wheatgenetics.survey.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ExperimentDao {
    @Query("SELECT * FROM experiments")
    fun getAll(): LiveData<List<Experiment>>

    @Update
    fun update(vararg e: Experiment?): Int

    @Insert
    fun insert(e: Experiment): Long

    @Delete
    fun delete(vararg e: Experiment?): Int
}