package com.ass.bulletin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ass.bulletin.repositories.bulletinrepository.BulletinRepository
import kotlinx.coroutines.launch

class BulletinViewModel(private val bulletinRepository: BulletinRepository) : ViewModel() {
    fun fetchData() {
        viewModelScope.launch {
            val assResponse = bulletinRepository.fetchBulletin()
            println("****$assResponse")
        }
    }
}