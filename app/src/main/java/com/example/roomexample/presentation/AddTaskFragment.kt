package com.example.roomexample.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.roomexample.data.local.Task
import com.example.roomexample.databinding.FragmentAddTaskBinding

class AddTaskFragment : Fragment() {

    private val viewModel: TaskViewModel by activityViewModels()

    private lateinit var binding: FragmentAddTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTaskBinding.inflate(inflater, container, false)

        loadData()

        initListener()

        return binding.root
    }
    private fun initListener() {
        binding.addTaskButton.setOnClickListener {
            val taskName = binding.taskEditText.text.toString()
            viewModel.insertTask(Task(taskName, "", ""))
        }
    }

    private fun loadData() {
        viewModel.allTask.observe(viewLifecycleOwner) {
            val tasksAsText = it.joinToString("\n") { it.task }
            showTasks(tasksAsText)
        }
    }

    private fun showTasks(tasks: String) {
        binding.showTasksTextView.text = tasks
    }
}