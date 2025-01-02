package com.example.a11_recyclerviewbasics_kotlin

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import pl.marbru.myapplication.Exercise
import pl.marbru.myapplication.Grade
import pl.marbru.myapplication.databinding.WordListItemBinding

class ExerciseViewHolder(private val binding: WordListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(exercise: Exercise) {
            binding.subjectName.text = exercise.name.toString()
            binding.taskCount.text = "" // Możesz dostosować logikę, jeśli jest potrzebna
            binding.grade.text = exercise.points.toString()
            binding.listNumber.text = exercise.text.toString()

        }
    }
