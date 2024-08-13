package com.ass.network.models.assFile.assFile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Alpine(
    @SerialName("aspects")
    val aspects: List<String>,
)