package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(InternalSerializationApi::class)
@Serializable
data class AvalancheProblemResponse(
    @SerialName("aspect_elevation")
    val aspectElevation: AspectElevation? =null,
    @SerialName("aspect_elevation_chart")
    val aspectElevationChart: String? =null,
    @SerialName("confidence")
    val confidence: String? =null,
    @SerialName("description")
    val description: Description? =null,
    @SerialName("distribution")
    val distribution: String? =null,
    @SerialName("kind")
    val kind: String? =null,
    @SerialName("probability")
    val probability: String? =null,
    @SerialName("sensitivity")
    val sensitivity: String? =null,
    @SerialName("size")
    val size: Int? =null,
    @SerialName("time_of_day")
    val timeOfDay: String? =null,
    @SerialName("trend")
    val trend: String? =null
)