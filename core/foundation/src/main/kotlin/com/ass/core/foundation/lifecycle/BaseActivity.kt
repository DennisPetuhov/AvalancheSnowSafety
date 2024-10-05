package com.ass.core.foundation.lifecycle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleEventObserver
import com.ass.core.foundation.permissions.PermissionUtils
import kotlinx.coroutines.launch


open class BaseActivity : ComponentActivity() {
    private var locationPermissionsGranted by mutableStateOf(false)
    private var shouldShowPermissionRationale by mutableStateOf(false)
    private var shouldDirectUserToApplicationSettings by mutableStateOf(false)
    var currentPermissionsStatus by mutableStateOf("")

    private lateinit var locationPermissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        locationPermissionsGranted = PermissionUtils.areLocationPermissionsGranted(this)
        shouldShowPermissionRationale = PermissionUtils.shouldShowPermissionRationale(this)
        currentPermissionsStatus =
            decideCurrentPermissionStatus(locationPermissionsGranted, shouldShowPermissionRationale)
    }

    @Composable
    protected fun CheckingCoarsePermission() {
        locationPermissionLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestMultiplePermissions(),
            onResult = { permissions ->
                locationPermissionsGranted = permissions.values.all { it }
                if (!locationPermissionsGranted) {
                    shouldShowPermissionRationale =
                        PermissionUtils.shouldShowPermissionRationale(this)
                }
                shouldDirectUserToApplicationSettings =
                    !shouldShowPermissionRationale && !locationPermissionsGranted
                currentPermissionsStatus = decideCurrentPermissionStatus(
                    locationPermissionsGranted,
                    shouldShowPermissionRationale
                )
            }
        )

        val lifecycleOwner = LocalLifecycleOwner.current
        DisposableEffect(lifecycleOwner) {
            PermissionUtils.observeLifecycleForPermissionRequest(
                lifecycleOwner,
                locationPermissionsGranted,
                shouldShowPermissionRationale,
                locationPermissionLauncher
            )
            onDispose { lifecycleOwner.lifecycle.removeObserver(LifecycleEventObserver { _, _ -> }) }
        }
    }

    @Composable
    fun ShowPermissionSnackBar(snackBarHostState: SnackbarHostState) {
        if (shouldShowPermissionRationale) {
            LaunchedEffect(Unit) {
                launch {
                    val userAction = snackBarHostState.showSnackbar(
                        message = "Please authorize location permissions",
                        actionLabel = "Approve",
                        duration = SnackbarDuration.Indefinite,
                        withDismissAction = true
                    )
                    if (userAction == SnackbarResult.ActionPerformed) {
                        shouldShowPermissionRationale = false
                        requestLocationPermissions()
                    } else {
                        shouldShowPermissionRationale = false
                    }
                }
            }
        }
        if (shouldDirectUserToApplicationSettings) {
            openApplicationSettings()
        }
    }

    private fun requestLocationPermissions() {
        PermissionUtils.requestLocationPermissions(this, locationPermissionLauncher)
    }

    private fun openApplicationSettings() {
        PermissionUtils.openApplicationSettings(this)
    }

    private fun decideCurrentPermissionStatus(
        locationPermissionsGranted: Boolean,
        shouldShowPermissionRationale: Boolean
    ): String {
        return if (locationPermissionsGranted) "Granted"
        else if (shouldShowPermissionRationale) "Rejected"
        else "Denied"
    }
}