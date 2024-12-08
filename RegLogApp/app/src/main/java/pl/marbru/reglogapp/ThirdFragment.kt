package pl.marbru.reglogapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import pl.marbru.reglogapp.databinding.FragmentFirstBinding
import pl.marbru.reglogapp.databinding.FragmentSecondBinding
import pl.marbru.reglogapp.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater)

        binding.errorText.text = ""

        binding.btnBack.setOnClickListener{
            val action = ThirdFragmentDirections.actionThirdFragmentToFirstFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }

        binding.btnRegister.setOnClickListener{
            val userName = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            val passwordConfirm = binding.etConfirmPassword.text.toString()

            if (userName.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()){
                binding.errorText.text = "Pola formularza nie mogą być puste"
                return@setOnClickListener
            }

            if (password != passwordConfirm){
                binding.errorText.text = "Podana hasła są różne"


            }

            else {
                DataProvider.users.add(User(userName, password))
                val action = ThirdFragmentDirections.actionThirdFragmentToSecondFragment()
                Navigation.findNavController(requireView()).navigate(action)
            }
        }


        return binding.root
    }

}