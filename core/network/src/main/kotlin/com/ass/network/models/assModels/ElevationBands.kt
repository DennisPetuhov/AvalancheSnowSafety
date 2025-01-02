package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(InternalSerializationApi::class)
@Serializable
data class ElevationBands(
    @SerialName("alpine")
    val alpine: AlpineX?=null,
    @SerialName("high_alpine")
    val highAlpine: HighAlpineX? = null,
    @SerialName("sub_alpine")
    val subAlpine: SubAlpineX? = null
)