package com.ass.bulletin.ui

import androidx.lifecycle.viewModelScope
import com.ass.bulletin.repositories.bulletinrepository.BulletinRepository
import com.ass.core.foundation.lifecycle.BaseViewModel
import com.ass.network.models.AssResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BulletinViewModel(private val bulletinRepository: BulletinRepository) :
    BaseViewModel<BulletinUiState>() {
    private val _uiState = MutableStateFlow(BulletinUiState.empty)
    override val uiState: StateFlow<BulletinUiState>
        get() = _uiState

    fun fetchData() {
        viewModelScope.launch {
            val assResponse: AssResponse = bulletinRepository.fetchBulletin()
            println("****$assResponse")
        }
    }
}