package com.ass.network.models.assFile.assFile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlpineXX(
    @SerialName("confidence")
    val confidence: String,
    @SerialName("trend")
    val trend: String,
    @SerialName("value")
    val value: String,
)