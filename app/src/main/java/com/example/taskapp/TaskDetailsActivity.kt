package com.example.taskapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TaskDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_details)

        val titleView: TextView = findViewById(R.id.titleView)
        val statusView: TextView = findViewById(R.id.statusView)

        val title = intent.getStringExtra("title") ?: "Нет данных"
        val status = intent.getStringExtra("status") ?: "Нет данных"
        val date = intent.getStringExtra("date") ?: "-"

        titleView.text = title
        statusView.text = "Status: $status | Date: $date"
    }
}
