package com.example.taskapp

data class TaskItem(
    val title: String,
    val status: String, // Статус задачи
    val date: String // Дата выполнения или "-"
)
