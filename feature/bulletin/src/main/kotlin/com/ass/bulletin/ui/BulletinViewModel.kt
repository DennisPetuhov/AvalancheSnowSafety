package com.ass.bulletin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ass.bulletin.repositories.bulletinrepository.BulletinRepository
import com.ass.network.models.AssResponse
import kotlinx.coroutines.launch

class BulletinViewModel(private val bulletinRepository: BulletinRepository) : ViewModel() {
    fun fetchData() {
        viewModelScope.launch {
            val assResponse: AssResponse = bulletinRepository.fetchBulletin()
            println("****$assResponse")
        }
    }
}