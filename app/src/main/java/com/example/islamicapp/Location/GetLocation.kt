package com.example.islamicapp.Location

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.example.islamicapp.DataModels.Cordinates
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices

class GetLocation(val context: Context) {
    private lateinit var locationRequest: LocationRequest
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    fun fetchLocation(): Cordinates {
        var cordinates = Cordinates(0, 0)
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        checkLocationPermission()
        val x = fusedLocationClient.lastLocation
        x.addOnSuccessListener {
            if (it != null) {
                cordinates.latitude = it.latitude.toLong()
                cordinates.longitude = it.longitude.toLong()
            }
        }
        return cordinates
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