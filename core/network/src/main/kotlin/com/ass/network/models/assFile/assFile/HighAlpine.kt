package com.ass.network.models.assFile.assFile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HighAlpine(
    @SerialName("aspects")
    val aspects: List<String>,
)