package com.ass.bulletin.ui

data class BulletinUiState(val name: String?) {
    companion object {
        val empty = BulletinUiState(name = null)
    }
}