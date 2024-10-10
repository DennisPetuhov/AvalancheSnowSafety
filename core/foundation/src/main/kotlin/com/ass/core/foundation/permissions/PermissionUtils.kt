package com.ass.core.foundation.permissions

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

object PermissionUtils {
    val permissions = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )

    @Composable
    fun rememberAllPermissionsGranted(): Boolean {
        val context = LocalContext.current
        return remember {
            permissions.all { permission ->
                ContextCompat.checkSelfPermission(
                    context,
                    permission
                ) == PackageManager.PERMISSION_GRANTED
            }
        }
    }

    @Composable
    fun rememberLauncherForPermissions(
        onPermissionsResult: (Map<String, Boolean>) -> Unit
    ): ActivityResultLauncher<Array<String>> {
        return rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestMultiplePermissions(),
            onResult = onPermissionsResult
        )
    }

    @Composable
    fun RequestMultiplePermissions() {
        val allPermissionsGranted = rememberAllPermissionsGranted()
        var permissionsGranted by remember { mutableStateOf(allPermissionsGranted) }
        val launcher = rememberLauncherForPermissions { permissionsMap ->
            permissionsGranted = permissionsMap.values.all { it }
        }
        LaunchedEffect(Unit) {
            if (!permissionsGranted) {
                launcher.launch(permissions)
            }
        }
    }
}