package com.example.roomexample.data

import androidx.lifecycle.LiveData
import com.example.roomexample.data.local.Task
import com.example.roomexample.data.local.TaskDAO

class TaskRepository(private val taskDao : TaskDAO) {

    // Este value va a contener todos los datos desde la BBDD
    val listAllTask : LiveData<List<Task>> = taskDao.getAllTask()

    // Función que insertara una tarea el la bbdd
    suspend fun insertTask(task : Task) {
        taskDao.insertTask(task)
    }

    // funcion que Actualiza una tarea
    suspend fun updateTask(task: Task){
        taskDao.updateTask(task)
    }
}
