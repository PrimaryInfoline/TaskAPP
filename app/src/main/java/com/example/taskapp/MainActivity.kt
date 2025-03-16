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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val tasks = loadTasksFromJson()

        val adapter = TaskAdapter(tasks)
        recyclerView.adapter = adapter
    }

    private fun loadTasksFromJson(): List<TaskItem> {
        val inputStream = assets.open("tasks.json")
        val reader = InputStreamReader(inputStream)
        val gson = Gson()
        val taskListType = object : TypeToken<List<TaskItem>>() {}.type
        return gson.fromJson(reader, taskListType)
    }
}
