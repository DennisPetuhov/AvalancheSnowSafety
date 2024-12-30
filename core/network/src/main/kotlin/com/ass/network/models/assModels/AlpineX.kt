package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(InternalSerializationApi::class)
@Serializable
data class AlpineX(
    @SerialName("lower")
    val lower: Int?=null,
    @SerialName("upper")
    val upper: Int?=null
)