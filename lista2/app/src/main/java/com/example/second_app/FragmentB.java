package com.example.second_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.second_app.databinding.FragmentBBinding;


public class FragmentB extends Fragment {

    private FragmentBBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBBinding.inflate(inflater, container)
        return inflater.inflate(R.layout.fragment_b, container, false);
    }
}