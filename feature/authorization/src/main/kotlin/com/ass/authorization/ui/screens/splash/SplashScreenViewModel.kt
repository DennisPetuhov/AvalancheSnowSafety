package com.ass.authorization.ui.screens.splash

import androidx.lifecycle.viewModelScope
import com.ass.authorization.repository.AuthorizationRepository
import com.ass.core.foundation.lifecycle.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashScreenViewModel(
    val authorizationRepository: AuthorizationRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) : BaseViewModel<SplashScreenUiState>() {
    override fun reloadData() {
        checkUser()
    }

    private val _uiState = MutableStateFlow(SplashScreenUiState.empty)
    override val uiState: StateFlow<SplashScreenUiState> = _uiState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = _uiState.value
    )

    fun checkUser() {
        viewModelScope.launch {
            withContext(ioDispatcher) {
                authorizationRepository.getUser().collect {
                    if (it.secondName.isNotBlank()) {
                        withContext(defaultDispatcher) {
                            _uiState.update { state -> state.copy(alreadyAuthorized = true) }
                        }
                    }
                }
            }
        }
    }
}

