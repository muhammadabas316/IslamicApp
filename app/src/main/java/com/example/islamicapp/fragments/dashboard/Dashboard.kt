package com.example.islamicapp.fragments.dashboard

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.islamicapp.R
import com.example.islamicapp.data_models.Coordinates
import com.example.islamicapp.databinding.FragmentDashboardBinding
import com.example.islamicapp.location.GetLocation
import com.example.islamicapp.utils.PermissionUtils
import com.example.islamicapp.utils.observe
import com.example.islamicapp.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.reflect.KProperty

@AndroidEntryPoint
class Dashboard : Fragment() {

    @Inject
    lateinit var permissionUtils: PermissionUtils
    var viewModel: DashboardViewModel by viewModels()

    private lateinit var binding: FragmentDashboardBinding
    lateinit var location: GetLocation
    private var points = Coordinates(0, 0)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        location = GetLocation(requireContext())
        lifecycleScope.launch {
            points = location.fetchLocation()
        }
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.prayer.setOnClickListener {
            if (permissionUtils.checkLocationPermission(requireActivity())) {
                if (!(points.latitude.equals(0)) && !(points.longitude.equals(0))) {
                    Log.d("CHECKLOC", "${points.latitude} ")
                    val x: Boolean = requireContext().observe()
                    if (x) {
                        requireContext().showToast(points.latitude.toString() + "\n" + points.longitude)
                        findNavController().navigate(R.id.action_dashboard_to_prayerDetails)
                    } else {
                        requireContext().showToast("Turn on Locationn")
                    }
                }
            } else {
                requireContext().showToast("Location Not fetched")
            }
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

private operator fun Any.setValue(
    dashboard: Dashboard,
    property: KProperty<*>,
    dashboardViewModel: DashboardViewModel
) {
}
