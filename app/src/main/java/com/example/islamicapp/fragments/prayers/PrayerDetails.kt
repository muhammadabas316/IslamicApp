package com.example.islamicapp.fragments.prayers

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.islamicapp.R
import com.example.islamicapp.databinding.FragmentPrayerDetailsBinding
import com.example.islamicapp.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PrayerDetails : Fragment() {
    private lateinit var binding: FragmentPrayerDetailsBinding
    private lateinit var cast: Array<String>
    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private lateinit var ad: ArrayAdapter<String>

    val vm: PrayerViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_prayer_details, container, false)
        cast = arrayOf("Ahly Tashaih", "Ahly Sunnat")
        autoCompleteTextView = binding.auto
        ad = ArrayAdapter(requireContext(), R.layout.listitem, cast)
        autoCompleteTextView.setAdapter(ad)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        autoCompleteTextView.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val item: String = p0?.getItemAtPosition(p2).toString()
                requireContext().showToast(item)
            }
        })
    }
}