package com.ass.bulletin.ui

import com.ass.bulletin.domain.models.AvalancheProblem
import com.ass.bulletin.domain.models.BulletinMetadata
import com.ass.bulletin.domain.models.HazardRatings
import com.ass.bulletin.domain.models.RecentAvalanche
import com.ass.core.foundation.lifecycle.BaseUiState

data class BulletinUiState(
    val bulletinMainText: String,
    val hazardRatings: HazardRatings,
    val avalancheProblems: List<AvalancheProblem>,
    val recentAvalanches: List<RecentAvalanche>,
    val snowPack: String,
    val weather: String,
    val bulletinMetadata: BulletinMetadata
): BaseUiState {
    companion object {
        val empty = BulletinUiState(
            bulletinMainText = "",
            hazardRatings = HazardRatings.EMPTY,
            avalancheProblems = emptyList(),
            recentAvalanches = emptyList(),
            snowPack = "",
            weather = "",
            bulletinMetadata = BulletinMetadata.EMPTY
        )
    }
}

