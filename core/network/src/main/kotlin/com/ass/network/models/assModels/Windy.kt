package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@OptIn(InternalSerializationApi::class)
@Serializable
data class Windy(
    @SerialName("latitude")
    val latitude: Double?=null,
    @SerialName("longitude")
    val longitude: Double?=null,
)