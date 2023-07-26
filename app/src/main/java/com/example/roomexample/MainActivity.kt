package com.example.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomexample.data.local.Task
import com.example.roomexample.data.local.TaskDAO
import com.example.roomexample.data.local.TaskDatabase
import com.example.roomexample.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        loadData()

        initListener()
    }

    private fun initListener() {
        binding.addTaskButton.setOnClickListener {
            val taskName = binding.taskEditText.text.toString()
            val task = Task(taskName, "26-07-2023", "27-07-2023")
            GlobalScope.launch {
                getDao().insertTask(task)
            }
        }
    }

    private fun loadData() {
        GlobalScope.launch {
            val tasks = getDao().getAllTask()

            val tasksAsText = tasks.joinToString("\n") { it.task }
            showTasks(tasksAsText)
        }
    }

    private suspend fun showTasks(tasks: String) {
        withContext(Dispatchers.Main) {
            binding.showTasksTextView.text = tasks
        }
    }

    private fun getDao(): TaskDAO {
        return TaskDatabase.getDatabase(this@MainActivity).getTaskDao()
    }
}