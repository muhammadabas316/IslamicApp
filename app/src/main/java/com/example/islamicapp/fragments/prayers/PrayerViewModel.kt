package com.example.islamicapp.fragments.prayers

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class PrayerViewModel @Inject constructor(
    @ApplicationContext val context: Context
) : ViewModel() {

}