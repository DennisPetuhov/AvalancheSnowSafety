package com.ass.core.storage.entity

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable
@InternalSerializationApi
@Serializable
data class AvalancheProblemEntity(
    val aspectElevationChart: String="",
    val confidence: String="",
    val description:String="",
    val distribution: String="",
    val kind: String="",
    val probability: String="",
    val sensitivity: String="",
    val size: Int = 0,
    val timeOfDay: String="",
    val trend: String=""
)
