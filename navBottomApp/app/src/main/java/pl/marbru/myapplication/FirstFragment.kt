package pl.marbru.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import pl.marbru.myapplication.databinding.FragmentFirstBinding

data class Grade(
    val name: String,
    val mean: String,
    val numberOfLists: Int
)

class FirstFragment : Fragment() {

    private val gradeList by lazy {
        mutableListOf(
            Grade("Mathematics", "5", 1),
            Grade("Physics", "4", 2),
            Grade("Chemistry", "5", 3),
            Grade("Biology", "4", 4),
            Grade("History", "5", 5)
        )
    }


    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater)

        binding.recyclerView.apply {
            adapter = GradeListAdapter(gradeList) {
                Toast.makeText(requireContext(), "Clicked: ${it.name}", Toast.LENGTH_SHORT).show()
            }
            layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }
}