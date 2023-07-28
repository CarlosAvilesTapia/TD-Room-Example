package com.example.roomexample.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomexample.data.local.Task
import com.example.roomexample.data.local.TaskDatabase
import com.example.roomexample.data.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TaskRepository

    //LiveData de tareas
    val allTask: LiveData<List<Task>>

    init {
        Log.i("ViewModel", "Create The ViewModel")
        val taskDao = TaskDatabase.getDatabase(application).getTaskDao()
        repository = TaskRepository(taskDao)
        allTask = repository.listAllTask
    }

    fun insertTask(task: Task) = viewModelScope.launch {
        repository.insertTask(task)
    }

    // Metodo que expone el respositorio
    fun updateTask(task: Task) = viewModelScope.launch {
        repository.updateTask(task)
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "ViewModel Destroy")
    }
}
