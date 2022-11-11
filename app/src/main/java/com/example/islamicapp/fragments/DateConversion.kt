package com.example.islamicapp.fragments

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.islamicapp.R
import com.example.islamicapp.databinding.FragmentDateConversionBinding
import com.example.islamicapp.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class DateConversion : Fragment() {
    val c = Calendar.getInstance()
    private var date = Date()
    private lateinit var binding: FragmentDateConversionBinding

    @Inject
    lateinit var provideString: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_date_conversion, container, false)
        return binding.root
    }

    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.check2.setOnClickListener() {
            val dpd = DatePickerDialog(
                requireContext(), { _, year, month, day ->
                    c.set(Calendar.YEAR, year)
                    c.set(Calendar.MONTH, month)
                    c.set(Calendar.DAY_OF_MONTH, day)
                    date = Date(year, month, day)
                    requireContext().showToast("$year")
                    requireContext().showToast("$month")
                    requireContext().showToast("$day")
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)
            )

            dpd.show()
            val formatedDate = SimpleDateFormat("dd/mm/yy").format(date)
            requireContext().showToast(formatedDate)
        }
    }
}