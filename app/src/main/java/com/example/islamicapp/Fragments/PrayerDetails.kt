package com.example.islamicapp.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.islamicapp.DataModels.Coordinates
import com.example.islamicapp.Location.GetLocation
import com.example.islamicapp.R
import com.example.islamicapp.Utils.showToast
import com.example.islamicapp.databinding.FragmentPrayerDetailsBinding

class PrayerDetails : Fragment() {
    private lateinit var location: GetLocation
    private lateinit var binding: FragmentPrayerDetailsBinding
    private lateinit var cast: Array<String>
    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private lateinit var ad: ArrayAdapter<String>
    private lateinit var points :Coordinates
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        cast = arrayOf("Fiqah Jaferia", "Fiqah Hanfia", "Ahly Hadees", "Deobandi", "Ahly Sunnat")
//        autoCompleteTextView = binding.auto


//        ad = ArrayAdapter<String>(requireContext(), R.layout.listitem, cast)
//        autoCompleteTextView.setAdapter(ad)

        location = GetLocation(requireContext())
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_prayer_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        location.checkLocationPermission()
        points = location.fetchLocation()
        binding.btn.setOnClickListener() {
            requireActivity().showToast( "${points.latitude}.toString()")
        }
    }

}