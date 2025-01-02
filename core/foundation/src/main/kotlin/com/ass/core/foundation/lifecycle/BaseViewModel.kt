package com.ass.core.foundation.lifecycle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlinx.coroutines.flow.collect

abstract class BaseViewModel<BaseUiState>(
    private val applicationLifecycleObserver: ApplicationLifecycleObserver =
        DefaultApplicationLifecycleObserver
) : ViewModel() {
    abstract val uiState: StateFlow<BaseUiState>
    init {
        observeLifecycleEvents()
       }
    private fun observeLifecycleEvents() {
        viewModelScope.launch {
            delay(LOAD_DELAY)
            applicationLifecycleObserver.lifecycleFlow.onEach {
                if (it == LifecycleEvent.OnResumed) {
                     Timber.d("Reload data called on: ${this@BaseViewModel}")
                    reloadData()
                }
            }.collect()
        }
    }
    abstract fun reloadData()

    companion object {
        private const val LOAD_DELAY = 10L
    }
}