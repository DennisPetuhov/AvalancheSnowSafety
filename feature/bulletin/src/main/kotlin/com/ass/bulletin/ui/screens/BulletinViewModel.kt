package com.ass.bulletin.ui.screens

import androidx.lifecycle.viewModelScope
import com.ass.bulletin.repositories.bulletinrepository.BulletinRepository
import com.ass.bulletin.ui.BulletinUiState
import com.ass.core.foundation.lifecycle.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class BulletinViewModel(private val bulletinRepository: BulletinRepository) :
    BaseViewModel<BulletinUiState>() {
    private val _uiState = MutableStateFlow(BulletinUiState.Companion.empty)
    override val uiState: StateFlow<BulletinUiState>
        get() = _uiState

    override fun reloadData() {
        fetchDataDb()
    }

    fun fetchDataApi() {
        viewModelScope.launch {
            bulletinRepository.fetchBulletin()
        }
    }

    fun fetchDataDb() {
        viewModelScope.launch {
            bulletinRepository.getActualBulletin().collect {
                _uiState.value = _uiState.value.copy(
                    bulletinMainText = it.mainDescription,
                    hazardRatings = it.hazardRatings,
                    avalancheProblems = it.avalancheProblems,
                    recentAvalanches = it.recentAvalanches,
                    snowPack = it.snowPack,
                    weather = it.weather,
                    bulletinMetadata = it.bulletinMetadata
                )
            }
        }
    }
}