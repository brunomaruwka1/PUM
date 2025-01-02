package com.example.a11_recyclerviewbasics_kotlin

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import pl.marbru.myapplication.Exercise
import pl.marbru.myapplication.Subject
import pl.marbru.myapplication.databinding.WordListItemBinding

class WordListViewHolder(private val binding: WordListItemBinding, private val onItemClick: (Subject) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    fun bind(subject: Subject) {
        binding.subjectName.text = subject.name
        binding.grade.text = "Grade: "+subject.grade
        binding.listNumber.text = "List number: "+ subject.listNumber.toString()
        binding.taskCount.text = "Number of tasks: "+subject.numberOfTasks.toString()
    // Obsługa kliknięcia
        binding.root.setOnClickListener {
            onItemClick(subject)
        }
    }
}
