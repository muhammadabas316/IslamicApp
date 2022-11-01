package com.example.islamicapp.Location

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.example.islamicapp.DataModels.Coordinates
import com.google.android.gms.location.*
import com.google.android.gms.tasks.Task

class GetLocation(val context: Context) {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    fun fetchLocation(): Coordinates {
        var coordinates = Coordinates(0, 0)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        checkLocationPermission()
        val x = fusedLocationClient.lastLocation
        x.addOnSuccessListener {
            if (it != null) {
                coordinates.latitude = it.latitude.toLong()
                coordinates.longitude = it.longitude.toLong()
            }
        }
        return coordinates
    }
    fun checkLocationPermission() {
        if ((ActivityCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED) && (ActivityCompat.checkSelfPermission(
                context, android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
                    )
        ) {
            ActivityCompat.requestPermissions(
                context as Activity, arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ), 1000
            )
        }
        return
    }
}