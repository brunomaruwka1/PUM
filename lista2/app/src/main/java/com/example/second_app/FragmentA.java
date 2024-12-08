package com.example.second_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.second_app.databinding.FragmentABinding;

public class FragmentA extends Fragment {

    private FragmentABinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentABinding.inflate(getLayoutInflater());

        binding.button.setOnClickListener(view -> {
            NavDirections action = FragmentADirections.actionFragmentAToFragmentB();
            Navigation.findNavController(requireView()).navigate(action);
        });

        return binding.getRoot();
    }
}