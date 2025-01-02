package pl.marbru.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a11_recyclerviewbasics_kotlin.ExerciseListAdapter
import com.example.a11_recyclerviewbasics_kotlin.WordListAdapter
import pl.marbru.myapplication.databinding.FragmentExerciseBinding
import pl.marbru.myapplication.databinding.FragmentHomeBinding


data class Exercise(
    val name: String,
    val text: String,
    val points: String
)

class ExerciseFragment : Fragment() {

    private val exerciseList by lazy {
        mutableListOf(
            Exercise("zadanie 1", "Podaj wynik dodawania 2+2.", "l.pkt.: 3"),
            Exercise("zadanie 2", "Podaj wynik mnozenia: 2x2.", "l.pkt.: 2"),
            Exercise("zadanie 3", "Podaj wynik mnozenia 4x14.", "l.pkt.: 2"),
            Exercise("zadanie 4", "Podaj wynik dzielenia 2/2.", "l.pkt.: 1"),
            Exercise("zadanie 5", "Podaj wynik dodawania 13/2.", "l.pkt.: 4"),
        )
    }

    private lateinit var binding: FragmentExerciseBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExerciseBinding.inflate(inflater)

        binding.recyclerView.apply {
            adapter = ExerciseListAdapter(exerciseList) {
                Toast.makeText(requireContext(), "Clicked: ${it.name}", Toast.LENGTH_SHORT).show()
            }
            layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }

}