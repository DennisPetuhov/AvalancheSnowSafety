package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(InternalSerializationApi::class)
@Serializable
data class AspectElevation(
    @SerialName("alpine")
    val alpine: Alpine?=null,
    @SerialName("high_alpine")
    val highAlpine: HighAlpine? = null,
    @SerialName("sub_alpine")
    val subAlpine: SubAlpine? = null
)
