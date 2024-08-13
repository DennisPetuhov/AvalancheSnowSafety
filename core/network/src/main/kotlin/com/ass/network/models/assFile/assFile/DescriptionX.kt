package com.ass.network.models.assFile.assFile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DescriptionX(
    @SerialName("en-UK")
    val english: String,
    @SerialName("ka-GE")
    val georgian: String,
)