package com.ass.core.foundation.permissions

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

object PermissionUtils {

    private fun isCoarseLocationPermissionGranted(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun isFineLocationPermissionGranted(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun areLocationPermissionsGranted(context: Context): Boolean {
        return isCoarseLocationPermissionGranted(context) && isFineLocationPermissionGranted(context)
    }

    fun shouldShowPermissionRationale(activity: ComponentActivity): Boolean {
        return activity.shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION)
    }

    fun requestLocationPermissions(
        activity: ComponentActivity,
        launcher: ActivityResultLauncher<Array<String>>
    ) {
        val locationPermissions = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        launcher.launch(locationPermissions)
    }

    fun openApplicationSettings(activity: ComponentActivity) {
        Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", activity.packageName, null)
        ).also {
            activity.startActivity(it)
        }
    }

    fun observeLifecycleForPermissionRequest(
        lifecycleOwner: LifecycleOwner,
        locationPermissionsGranted: Boolean,
        shouldShowPermissionRationale: Boolean,
        launcher: ActivityResultLauncher<Array<String>>
    ) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START &&
                !locationPermissionsGranted &&
                !shouldShowPermissionRationale
            ) {
                requestLocationPermissions(lifecycleOwner as ComponentActivity, launcher)
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
    }
}