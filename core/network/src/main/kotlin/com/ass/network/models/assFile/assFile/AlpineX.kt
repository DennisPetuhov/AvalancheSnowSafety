package com.ass.network.models.assFile.assFile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlpineX(
    @SerialName("lower")
    val lower: Int,
    @SerialName("upper")
    val upper: Int,
)