package com.ass.authorization.ui.screens.splash

data class SplashScreenUiState(val isLoading: Boolean) {
    companion object {
        val empty = SplashScreenUiState(isLoading = true)
    }
}