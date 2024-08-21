package com.ass.core.storage.entities.bulletinModels
import kotlinx.serialization.Serializable

@Serializable
data class HazardRatingsEntity(
    val alpineEntity: AlpineEntity?,
    val highAlpineEntity: HighAlpineEntity?,
    val overallEntity: OverallEntity?,
    val subAlpineEntity: SubAlpineEntity?,
)