package com.ass.network.models.assFile.assFile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ElevationBands(
    @SerialName("alpine")
    val alpine: AlpineX,
    @SerialName("high-alpine")
    val highAlpine: HighAlpineX,
    @SerialName("sub-alpine")
    val subAlpine: SubAlpineX,
)