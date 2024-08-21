package com.ass.core.storage.entities.bulletinModels
import kotlinx.serialization.Serializable

@Serializable
data class DetailsEntity(
    val area: String?,
    val forecaster: String?,
    val formattedTime: String?,
    val time: String?,
)