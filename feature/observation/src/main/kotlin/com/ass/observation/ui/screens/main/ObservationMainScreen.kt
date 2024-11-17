package com.ass.observation.ui.screens.main

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import com.ass.core.designsystem.R
import com.ass.core.designsystem.components.input.MainTextField
import com.ass.core.foundation.permissions.PermissionUtils
import com.ass.core.foundation.permissions.PermissionUtils.PhilipPlinerLauncher
import com.ass.core.foundation.permissions.PermissionUtils.permissions
import com.ass.core.foundation.permissions.PermissionUtils.rememberAllPermissionsGranted
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel


@Composable
fun ObservationMainScreenRoute(
    navigateToCommonScreen: () -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ObservationMainScreenViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val dialogQueue = viewModel.visiblePermissionDialogQueue

    ObservationMainScreen(
        viewModel = viewModel,
        navigateToCommonScreen = navigateToCommonScreen,
        setCurrentDate = viewModel::getCurrentDate,
        setDateFromCalendar = viewModel::convertTimeMillisToDate,
        confirmLocationAndTime = viewModel::confirmLocationAndDate,
        dialogQueue = dialogQueue,
        uiState = uiState,
        modifier = modifier,
    )

}


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ObservationMainScreen(
    viewModel: ObservationMainScreenViewModel,
    navigateToCommonScreen: () -> Unit,
    setDateFromCalendar: suspend (Long) -> String,
    setCurrentDate: suspend () -> String,
    confirmLocationAndTime: (nameLocation: String, date: String) -> Unit,
    dialogQueue: SnapshotStateList<String>,
    uiState: ObservationScreenUiState,
    modifier: Modifier,
) {
    val dateInput = rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(text = ""))
    }
    var nameLocationInput by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(text = ""))
    }
    val coroutineScope = rememberCoroutineScope()
    val openDatePicker: MutableState<Boolean> = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    var isFieldEnabled by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val state = rememberMultiplePermissionsState(permissions)
    val context = LocalContext.current
    val multiplePermissionResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = { perms ->
            permissions.forEach { permission ->
                viewModel.onPermissionResult(
                    permission = permission,
                    isGranted = perms[permission] == true
                )
            }
        }
    )

    val allPermissionsGranted =
        permissions.all { permission ->
            ContextCompat.checkSelfPermission(
                context,
                permission
            ) == PackageManager.PERMISSION_GRANTED
        }



    LaunchedEffect(Unit) { dateInput.value = TextFieldValue(text = setCurrentDate()) }
    LaunchedEffect(Unit) {    multiplePermissionResultLauncher.launch(permissions.toTypedArray())}
//    PermissionUtils.requestMultiplePermissions(
//        context,
//        snackbarHostState,
//        state,
//        coroutineScope
//    )



    Surface(modifier = modifier.fillMaxSize()) {
        Scaffold(
            topBar = {},
            floatingActionButton = {},
//            snackbarHost = { SnackbarHost(snackbarHostState) },
            modifier = modifier.fillMaxSize()
        ) { paddingValues ->
//
//            SnackbarHost(
//                modifier = Modifier
//                    .padding(top = Paddings.padding24dp)
//                    .zIndex(1f),
//                hostState = snackbarHostState
//            ) { snackbarData: SnackbarData ->
////                CustomSnackBar(message = snackbarData.visuals.message)
//                CustomSnackBar(message = "snackbarData.visuals.message")
//            }




            dialogQueue
                .reversed()
                .forEach { permission ->
                    PermissionDialog(
                        permissionTextProvider = when (permission) {
                            Manifest.permission.ACCESS_FINE_LOCATION -> {
                                CameraPermissionTextProvider()
                            }

                            Manifest.permission.ACCESS_COARSE_LOCATION -> {
                                RecordAudioPermissionTextProvider()
                            }

                            else -> return@forEach
                        },
                        isPermanentlyDeclined = allPermissionsGranted,
                        onDismiss = viewModel::dismissDialog,
                        onOkClick = {

                            viewModel.dismissDialog()

                            multiplePermissionResultLauncher.launch(
                                arrayOf(permission)
                            )
                        },
                        onGoToAppSettingsClick = {
                            val intent = Intent(
                                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                Uri.fromParts("package", context.packageName, null)
                            )
                            context.startActivity(intent)
                        }
                    )
                }


            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(300.dp)
                ) {
//            MapScreen(viewModel = viewModel)
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.fillMaxWidth()
                ) {
                    MainTextField(
                        isBorderLess = true,
                        inputFieldValue = nameLocationInput,
                        onValueChange = { nameLocationInput = it },
                        enabled = true,
                        imeAction = ImeAction.Done,
                        modifier = Modifier
                            .weight(1f)
                            .focusRequester(focusRequester),
                    )
                    OutlinedButton(
                        onClick = {
                            focusRequester.requestFocus()
                            keyboardController?.show()
                            isFieldEnabled = true
                        },
                        modifier = Modifier
                            .wrapContentSize()

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_edit_note),
                            contentDescription = stringResource(R.string.icon_name_description)
                        )
                        Text(stringResource(R.string.name_location))
                    }
                }
                Row(
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    BasicTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                ) {
                    MainTextField(
                        inputFieldValue = dateInput.value,
                        onValueChange = { dateInput.value = it },
                        leadingIcon = {
                            Image(
                                modifier = Modifier,
                                painter = painterResource(id = R.drawable.icon_today),
                                contentDescription = stringResource(R.string.calendar_icon)
                            )
                        },
                        enabled = false,
                        modifier = Modifier
                            .weight(1f)
                            .clickable { openDatePicker.value = !openDatePicker.value }
                    )
                    TextButton(
                        onClick = {
                            coroutineScope.launch {
                                dateInput.value = TextFieldValue(setCurrentDate())
                            }
                        },
                        modifier = modifier.wrapContentWidth()
                    ) {
                        Row(
                            modifier = modifier.wrapContentWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_access_time),
                                contentDescription = stringResource(R.string.access_time)
                            )
                            Text(stringResource(R.string.now))
                        }
                    }
                }
                HorizontalDivider(
                    thickness = 3.dp,
                    color = DividerDefaults.color,
                    modifier = modifier.padding(horizontal = 20.dp, vertical = 30.dp)
                )
                ElevatedButton(onClick = {
                    confirmLocationAndTime(nameLocationInput.text, dateInput.value.text)
                }, modifier = modifier.fillMaxWidth()) {
                    Text(text = "Confirm location and time")
                }
                MyDatePickerDialog(
                    openDialog = openDatePicker,
                    dateInput = dateInput,
                    setDate = setDateFromCalendar
                )
            }
        }
    }
}