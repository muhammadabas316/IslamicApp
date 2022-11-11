package com.example.islamicapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.islamicapp.R
import com.example.islamicapp.databinding.FragmentDuaAzkarDetailsBinding


class DuaAzkarDetails : Fragment() {
    private lateinit var binding: FragmentDuaAzkarDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_dua_azkar_details, container, false)
        return binding.root
    }
}