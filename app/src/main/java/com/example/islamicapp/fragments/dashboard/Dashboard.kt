package com.example.islamicapp.fragments.dashboard

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.islamicapp.R
import com.example.islamicapp.databinding.FragmentDashboardBinding
import com.example.islamicapp.utils.checkLocationPermission
import com.example.islamicapp.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.KProperty

class Dashboard : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.prayer.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_prayerDetails)
        }
        binding.dateCon.setOnClickListener() {
            findNavController().navigate(R.id.action_dashboard_to_dateConversion)
        }
        binding.quran.setOnClickListener() {
            findNavController().navigate(R.id.action_dashboard_to_quranKareem)
        }
        binding.dua.setOnClickListener() {
            findNavController().navigate(R.id.action_dashboard_to_duaAzkarDetails)
        }
        binding.kalma.setOnClickListener() {
            findNavController().navigate(R.id.action_dashboard_to_kalma)
        }
        binding.mode.setOnClickListener() {
            requireActivity().showToast("Mode button pressed")
        }
    }
}
