package pl.marbru.reglogapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import pl.marbru.reglogapp.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)

        binding.fabA.setOnClickListener{
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(13)
            Navigation.findNavController(requireView()).navigate(action)
        }

        binding.fabB.setOnClickListener{
            val action = FirstFragmentDirections.actionFirstFragmentToThirdFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }

        return binding.root
    }


}