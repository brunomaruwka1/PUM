package com.example.a11_recyclerviewbasics_kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.marbru.myapplication.Subject
import pl.marbru.myapplication.databinding.WordListItemBinding

class WordListAdapter(
    private val wordList: MutableList<Subject>,
    private val onItemClick: (Subject) -> Unit // Callback obsługujący kliknięcia
) : RecyclerView.Adapter<WordListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordListViewHolder {
        val binding = WordListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WordListViewHolder(binding, onItemClick) // Przekazujemy callback do ViewHoldera
    }

    override fun onBindViewHolder(holder: WordListViewHolder, position: Int) {
        val subject = wordList[position]
        holder.bind(subject) // Bindowanie danych
    }

    override fun getItemCount(): Int = wordList.size
}
