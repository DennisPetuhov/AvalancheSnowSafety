package com.ass.observation.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.ass.core.designsystem.R
import com.ass.core.designsystem.components.input.MainTextField
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
    Surface(modifier = modifier.fillMaxSize()) {
        Scaffold(
            topBar = {},
            floatingActionButton = {},
            modifier = modifier.fillMaxSize()
        ) { paddingValues ->
            ObservationMainScreen(
                navigateToCommonScreen = navigateToCommonScreen,
                setCurrentDate = viewModel::getCurrentDate,
                setDateFromCalendar = viewModel::convertTimeMillisToDate,
                confirmLocationAndTime = viewModel::confirmLocationAndDate,
                paddingValues = paddingValues,
                uiState = uiState,
                modifier = modifier
            )
        }
    }
}

@Composable
fun ObservationMainScreen(
    navigateToCommonScreen: () -> Unit,
    setDateFromCalendar: suspend (Long) -> String,
    setCurrentDate: suspend () -> String,
    confirmLocationAndTime: (nameLocation: String, date: String) -> Unit,
    paddingValues: PaddingValues,
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

    LaunchedEffect(Unit) { dateInput.value = TextFieldValue(text = setCurrentDate()) }

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
            BasicTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())
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
                    coroutineScope.launch { dateInput.value = TextFieldValue(setCurrentDate()) }
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