package com.example.taskapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleView: TextView = itemView.findViewById(R.id.task_title)
    private val statusView: TextView = itemView.findViewById(R.id.task_status)

    fun bind(item: TaskItem, onClick: (TaskItem) -> Unit) {
        titleView.text = item.title
        statusView.text = "Status: ${item.status} | Date: ${item.date}"
        itemView.setOnClickListener { onClick(item) }
    }
}
