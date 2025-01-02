package pl.marbru.myapplication


import com.example.a11_recyclerviewbasics_kotlin.GradeListViewHolder


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.marbru.myapplication.Grade
import pl.marbru.myapplication.databinding.WordListItemBinding


class GradeListAdapter(
    private val wordList: MutableList<Grade>,
    private val onItemClick: (Grade) -> Unit // Updated to pass the Grade object
) : RecyclerView.Adapter<GradeListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradeListViewHolder {
        return GradeListViewHolder(
            WordListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = wordList.size

    override fun onBindViewHolder(holder: GradeListViewHolder, position: Int) {
        val currentItem = wordList[position]
        holder.bind(currentItem)
    }
}
