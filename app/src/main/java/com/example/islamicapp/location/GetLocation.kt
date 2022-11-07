package com.example.islamicapp.location

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.example.islamicapp.data_models.Coordinates
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GetLocation(val context: Context) {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
private lateinit var x : Coordinates
    fun loc() : Coordinates{
        CoroutineScope(Dispatchers.IO).launch {
           x= fetchLocation()

        }
        return x
    }
    @SuppressLint("MissingPermission")
    suspend fun fetchLocation(): Coordinates {
        var coordinates = Coordinates(0, 0)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        val x = fusedLocationClient.lastLocation
        x.addOnSuccessListener {
            if (it != null) {
                coordinates.latitude = it.latitude.toLong()
                coordinates.longitude = it.longitude.toLong()
            }
        }
        x.addOnFailureListener() {
            Log.d("LOCATIONFAILURE", "Location Not Fetched: ")
        }
        return coordinates
    }
}