package com.ass.observation.ui.screens.main

import com.ass.core.foundation.lifecycle.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ObservationMainScreenViewModel(private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default) :
    BaseViewModel<ObservationScreenUiState>() {
    private val _uiState = MutableStateFlow(ObservationScreenUiState.empty)
    override val uiState: StateFlow<ObservationScreenUiState> = _uiState


    suspend fun getCurrentDate(): String {
        return withContext(defaultDispatcher) {
            val currentTimeMillis = System.currentTimeMillis()
            convertTimeMillisToDate(currentTimeMillis)
        }
    }

    suspend fun convertTimeMillisToDate(timeInMillis: Long): String {
        return withContext(defaultDispatcher) {
            val date = Date(timeInMillis)
            val dateFormat = SimpleDateFormat("EEE MMM yyyy HH:mm", Locale.getDefault())
            dateFormat.format(date)
        }
    }

    fun confirmLocationAndDate(nameOfLocation: String, date: String) {
        _uiState.value = _uiState.value.copy(date = date, nameOfLocation = nameOfLocation)
        println("$date $nameOfLocation")
    }
}