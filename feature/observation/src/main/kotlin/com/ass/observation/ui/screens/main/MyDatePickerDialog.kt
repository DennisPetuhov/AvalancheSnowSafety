package com.ass.observation.ui.screens.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import com.ass.core.designsystem.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDatePickerDialog(
    dateInput: MutableState<TextFieldValue>,
    openDialog: MutableState<Boolean>,
    setDate: suspend (Long) -> String
) {
    val coroutineScope = rememberCoroutineScope()
    val datePickerState = rememberDatePickerState()
    val confirmEnabled =
        remember { derivedStateOf { datePickerState.selectedDateMillis != null } }

    if (openDialog.value) {
        DatePickerDialog(
            onDismissRequest = { openDialog.value = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        coroutineScope.launch {
                            dateInput.value =
                                TextFieldValue(text = datePickerState.selectedDateMillis?.let {
                                    setDate(it)
                                } ?: "")
                        }
                        openDialog.value = false
                    },
                    enabled = confirmEnabled.value
                ) { Text(stringResource(R.string.ok)) }
            },
            dismissButton = {
                TextButton(onClick = { openDialog.value = false })
                { Text(stringResource(R.string.cancel)) }
            },
            modifier = Modifier.fillMaxSize(),
        ) { DatePicker(state = datePickerState) }
    }
}