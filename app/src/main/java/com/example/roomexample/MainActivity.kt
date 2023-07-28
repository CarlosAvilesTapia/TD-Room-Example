package com.example.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomexample.data.local.Task
import com.example.roomexample.data.local.TaskDAO
import com.example.roomexample.data.local.TaskDatabase
import com.example.roomexample.data.local.TaskRepository
import com.example.roomexample.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var repository: TaskRepository



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    private fun getDao(): TaskDAO {
        return TaskDatabase.getDatabase(this@MainActivity).getTaskDao()
    }
}