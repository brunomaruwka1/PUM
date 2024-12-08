package pl.marbru.reglogapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import pl.marbru.reglogapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater)

//        binding.textView.text = arguments?.getInt("value").toString() // odebranie danych

        binding.btnBack2.setOnClickListener{
            val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }

        binding.btnLogin.setOnClickListener {
            val userName = binding.etUsername.text.toString()
            val passwordToCheck = binding.etPassword.text.toString()

            val userExists =
                DataProvider.users.any { it.login == userName && it.password == passwordToCheck }

            if (userExists) {
                val action = SecondFragmentDirections.actionSecondFragmentToFourthFragment(userName)
                Navigation.findNavController(requireView()).navigate(action)
            } else {
                binding.errorText.text = "Nie ma takiego uzytkownika"
            }
        }
        return binding.root
    }


}