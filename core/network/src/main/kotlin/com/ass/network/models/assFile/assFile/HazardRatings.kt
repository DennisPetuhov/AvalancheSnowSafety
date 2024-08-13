package com.ass.network.models.assFile.assFile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HazardRatings(
    @SerialName("alpine")
    val alpine: AlpineXX,
    @SerialName("high-alpine")
    val highAlpine: HighAlpineXX,
    @SerialName("")
    val overall: Overall,
    @SerialName("sub-alpine")
    val subAlpine: SubAlpineXX,
)