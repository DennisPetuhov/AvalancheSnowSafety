package com.ass.authorization.ui.screens.splash

data class SplashScreenUiState(
    private val isLoading: Boolean,
    val alreadyAuthorized: Boolean
) {
    companion object {
        val empty = SplashScreenUiState(isLoading = true, alreadyAuthorized = false)
    }
}