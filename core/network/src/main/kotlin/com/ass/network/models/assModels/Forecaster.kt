package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(InternalSerializationApi::class)
@Serializable
data class Forecaster(
    @SerialName("name")
    val name: String?=null,
    @SerialName("organisation")
    val organisation: String?=null
)