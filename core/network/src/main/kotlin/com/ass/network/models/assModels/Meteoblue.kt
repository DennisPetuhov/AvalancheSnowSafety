package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@OptIn(InternalSerializationApi::class)
@Serializable
data class Meteoblue(
    @SerialName("location_id")
    val locationId: String,
)