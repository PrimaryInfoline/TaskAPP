package com.example.taskapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskapp.R

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleView: TextView = itemView.findViewById(R.id.task_title)
    private val descriptionView: TextView = itemView.findViewById(R.id.task_description)
    private val statusView: TextView = itemView.findViewById(R.id.task_status)

    fun bind(item: TaskItem) {
        titleView.text = item.title
        descriptionView.text = item.description
        statusView.text = "Status: ${item.status} | Date: ${item.date}"
    }
}
