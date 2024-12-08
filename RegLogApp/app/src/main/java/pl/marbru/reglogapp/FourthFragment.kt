package pl.marbru.reglogapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import pl.marbru.reglogapp.databinding.FragmentFourthBinding


class FourthFragment : Fragment() {

    private lateinit var binding: FragmentFourthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFourthBinding.inflate(inflater)

        binding.mainText.text = "Hello "+(arguments?.getString("value") ?: 0).toString()+"!"

        binding.btnBack3.setOnClickListener{
            val action = FourthFragmentDirections.actionFourthFragmentToFirstFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }

        return binding.root
    }
}