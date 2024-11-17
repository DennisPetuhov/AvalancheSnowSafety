package com.ass.core.foundation.permissions

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.ass.core.foundation.permissions.PermissionUtils.permissions
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
@Composable
fun requestMultiplePermissions(setPermissionCounter: ((String) -> Unit)? = null) {
    val context = LocalContext.current
    val allPermissionsGranted = remember {
        permissions.all { permission ->
            ContextCompat.checkSelfPermission(
                context,
                permission
            ) == PackageManager.PERMISSION_GRANTED
        }
    }
    var permissionsGranted by remember { mutableStateOf(allPermissionsGranted) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = { permissionsMap ->
            permissionsGranted = permissionsMap.values.all { it }
            if (!permissionsMap.values.all { it }) {
                setPermissionCounter?.let { it("first") }
            } else {
                setPermissionCounter?.let { it("first true") }
            }
        }
    )
    LaunchedEffect(Unit) {
        if (!permissionsGranted) {
            launcher.launch(permissions.toTypedArray())
        }
    }
}
@OptIn(ExperimentalPermissionsApi::class)
object PermissionUtils {
    val permissions = listOf(
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
    fun requestMultiplePermissions(setPermissionCounter: ((String) -> Unit)? = null) {
        val allPermissionsGranted = rememberAllPermissionsGranted()
        var permissionsGranted by remember { mutableStateOf(allPermissionsGranted) }
        val launcher = rememberLauncherForPermissions { permissionsMap ->
            permissionsGranted = permissionsMap.values.all { it }
            if (!permissionsMap.values.all { it }) {
                setPermissionCounter?.let { it("first") }
            } else {
                setPermissionCounter?.let { it("first true") }
            }
        }
        LaunchedEffect(Unit) {
            if (!permissionsGranted) {
                launcher.launch(permissions.toTypedArray())

            }
        }
    }


    fun requestMultiplePermissions(
        context: Context,
        snackbarHostState: SnackbarHostState,
        state: MultiplePermissionsState, scope: CoroutineScope
    ) {
        when {
            state.allPermissionsGranted -> {}

            state.shouldShowRationale -> {
                scope.launch {
                    val result = snackbarHostState.showSnackbar(
                        message = "Location permissions required for Observations",
                        actionLabel = "Apply"
                    )

                    when (result) {
                        SnackbarResult.ActionPerformed -> {

                            state.launchMultiplePermissionRequest()
                        }

                        SnackbarResult.Dismissed -> {
                            val intent = Intent(
                                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                Uri.fromParts("package", context.packageName, null)
                            )
                            context.startActivity(intent)
                        }
                    }
                }
            }

            else -> {
                state.launchMultiplePermissionRequest()
            }
        }

    }

    @Composable
    fun PhilipPlinerLauncher(onPermissionResult:(String, Boolean)->Unit,modifier: Modifier = Modifier) {
        val multiplePermissionResultLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestMultiplePermissions(),
            onResult = { perms ->
                permissions.forEach { permission ->
//                    viewModel.onPermissionResult(
//                        permission = permission,
//                        isGranted = perms[permission] == true
//                    )
                    onPermissionResult(permission, perms[permission] == true)
                }
            }
        )

    }


}
