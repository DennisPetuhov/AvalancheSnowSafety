package com.ass.core.storage.entities.bulletinModels
import kotlinx.serialization.Serializable

@Serializable
data class OverallEntity(
    val confidence: String?,
    val trend: String?,
    val value: String?,
)