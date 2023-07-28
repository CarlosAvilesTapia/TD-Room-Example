package com.example.roomexample.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

// Interfaz que nos permite acceder a la información en la base de datos

const val defaultStrategy = OnConflictStrategy.IGNORE
@Dao
interface TaskDAO {


    @Insert(onConflict = defaultStrategy)
    suspend fun insertTask(task: Task)

    @Insert(onConflict = defaultStrategy)
    suspend fun insertMultipleTask(list: List<Task>)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteOneTask(task: Task)

    @Query("SELECT * FROM task_table ORDER BY id ASC")
    fun getAllTask(): LiveData<List<Task>>
}