package com.ass.core.foundation.lifecycle

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<T>() : ViewModel() {
    abstract val uiState: StateFlow<T>
}