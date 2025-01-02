package com.example.a11_recyclerviewbasics_kotlin

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import pl.marbru.myapplication.Grade
import pl.marbru.myapplication.databinding.WordListItemBinding

class GradeListViewHolder(private val binding: WordListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(grade: Grade) {
        binding.subjectName.text = grade.name.toString()
        binding.taskCount.text = "Number of lists: "+grade.numberOfLists.toString()
        binding.grade.text = "Mean: "+grade.mean.toString()
        binding.listNumber.text = ""
    }
}
