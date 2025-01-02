package com.example.a11_recyclerviewbasics_kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.marbru.myapplication.Exercise

import pl.marbru.myapplication.databinding.WordListItemBinding

class ExerciseListAdapter(
    private val wordList: MutableList<Exercise>,
    private val onItemClick: (Exercise) -> Unit // Updated to pass the Subject object
) : RecyclerView.Adapter<ExerciseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder{
        return ExerciseViewHolder(
            WordListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = wordList.size

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val currentItem = wordList[position]
        holder.bind(currentItem)
    }
}
