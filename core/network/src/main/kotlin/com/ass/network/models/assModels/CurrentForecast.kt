package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(InternalSerializationApi::class)
@Serializable
data class CurrentForecast(
    @SerialName("details")
    val details: Details?=null,
    @SerialName("file")
    val file: AssFile?=null,
    @SerialName("forecast")
    val forecast: Forecast?=null
)
