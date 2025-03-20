package com.example.taskapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TaskDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_details)

        val titleView: TextView = findViewById(R.id.task_title)
        val statusView: TextView = findViewById(R.id.task_status)
        val dateView: TextView = findViewById(R.id.task_date)
        val descriptionView: TextView = findViewById(R.id.task_description) // описание
        val linkButton: Button = findViewById(R.id.learn_more_button)

        // Получаем данные из Intent
        val title = intent.getStringExtra("title")
        val status = intent.getStringExtra("status")
        val date = intent.getStringExtra("date")
        val description = intent.getStringExtra("description")

        // Устанавливаем значения в UI
        titleView.text = title
        statusView.text = "Status: $status"
        dateView.text = "Date: $date"
        descriptionView.text = description

        // Кнопка для открытия ссылки
        linkButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, android.net.Uri.parse("https://www.google.com"))
            startActivity(intent)
        }
    }
}
