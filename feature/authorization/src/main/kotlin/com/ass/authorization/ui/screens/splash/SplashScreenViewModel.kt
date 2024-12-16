package com.ass.authorization.ui.screens.splash

import androidx.lifecycle.viewModelScope
import com.ass.core.foundation.lifecycle.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val SPLASH_SCREEN_DELAY = 1000L

class SplashScreenViewModel : BaseViewModel<SplashScreenUiState>() {
    init {
        checkConnectionStatus()
    }
    private val _uiState = MutableStateFlow(SplashScreenUiState.empty)
    override val uiState: StateFlow<SplashScreenUiState> = _uiState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = SplashScreenUiState.empty
    )

    override fun reloadData() {
    }

    private fun checkConnectionStatus() = viewModelScope.launch {
        delay(timeMillis = SPLASH_SCREEN_DELAY)
        _uiState.update { it.copy(isLoading = false) }
    }
}