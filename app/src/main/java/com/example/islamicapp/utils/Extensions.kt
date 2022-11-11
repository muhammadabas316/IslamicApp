package com.example.islamicapp.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.islamicapp.R

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun ImageView.loadImage(image: String) {
    Glide.with(this)
        .load(image)
        .placeholder(R.drawable.ic_launcher_foreground)
        .into(this)
}

fun TextView.showText(msg: String) {
    this.text = msg
}

@RequiresApi(Build.VERSION_CODES.P)
fun Context.observe(): Boolean {
    val x: Boolean
    val lm: LocationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    if (lm.isLocationEnabled) {
        Log.d("LOCATION", "Enabled location")
    } else
        Log.d("Location", "Not Enabled")
    var gpsEnabled = false
    var networkEnabled = false

    try {
        gpsEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
    } catch (ex: Exception) {

    }
    try {
        networkEnabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    } catch (ex: Exception) {

    }
    x = gpsEnabled || networkEnabled
    return x
}


fun Activity.checkLocationPermission(): Boolean {

    return if (ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    ) {
        true
    } else {
        ActivityCompat.requestPermissions(
            this, arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ), 1000
        )
        false
    }
}
