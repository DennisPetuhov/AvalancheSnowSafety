package com.ass.network.models.assFile.assFile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AvalancheProblem(
    @SerialName("aspect_elevation")
    val aspectElevation: AspectElevation,
    @SerialName("confidence")
    val confidence: String,
    @SerialName("description")
    val description: DescriptionX,
    @SerialName("distribution")
    val distribution: String,
    @SerialName("kind")
    val kind: String,
    @SerialName("sensitivity")
    val sensitivity: String,
    @SerialName("size")
    val size: Int,
    @SerialName("time_of_day")
    val timeOfDay: String,
    @SerialName("trend")
    val trend: String,
)