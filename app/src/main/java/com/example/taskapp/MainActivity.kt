package com.example.taskapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val tasks = loadTasksFromJson()
        taskAdapter = TaskAdapter(tasks) { task ->
            val intent = Intent(this, TaskDetailsActivity::class.java).apply {
                putExtra("title", task.title)
                putExtra("status", task.status)
                putExtra("date", task.date)
            }
            startActivity(intent)
        }

        recyclerView.adapter = taskAdapter
    }

    private fun loadTasksFromJson(): List<TaskItem> {
        val inputStream = assets.open("tasks.json")
        val reader = InputStreamReader(inputStream)
        val taskListType = object : TypeToken<List<TaskItem>>() {}.type
        return Gson().fromJson(reader, taskListType)
    }
}
