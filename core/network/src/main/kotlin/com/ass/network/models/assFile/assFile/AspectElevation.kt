package com.ass.network.models.assFile.assFile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AspectElevation(
    @SerialName("alpine")
    val alpine: Alpine,
    @SerialName("high-alpine")
    val highAlpine: HighAlpine,
    @SerialName("sub-alpine")
    val subAlpine: SubAlpine,
)