package pl.marbru.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.marbru.myapplication.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater)
        return binding.root
    }
}
