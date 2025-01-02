package pl.marbru.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a11_recyclerviewbasics_kotlin.ExerciseListAdapter
import com.example.a11_recyclerviewbasics_kotlin.WordListAdapter
import pl.marbru.myapplication.databinding.FragmentHomeBinding

data class Subject(
    val name: String,
    val grade: String,
    val listNumber: Int,
    val numberOfTasks: Int
)


class HomeFragment : Fragment() {

    private val subjectList by lazy {
        mutableListOf(
            Subject("Mathematics", "5", 1, 5),
            Subject("Physics", "4", 2, 4),
            Subject("Chemistry", "5", 3, 6),
            Subject("Biology", "4", 4, 3),
            Subject("History", "3", 5, 2)
        )
    }


    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)




        binding.recyclerView.apply {
            adapter = WordListAdapter(subjectList) { subject ->
                if (subject.name == "Mathematics") { // Sprawdzenie czy to pierwszy element
                    val navController = Navigation.findNavController(requireView())
                    navController.navigate(R.id.action_homeFragment_to_exerciseFragment)
                } else {
                    Toast.makeText(requireContext(), "Clicked: ${subject.name}", Toast.LENGTH_SHORT).show()
                }
            }
            layoutManager = LinearLayoutManager(requireContext())
        }
        return binding.root
    }
}