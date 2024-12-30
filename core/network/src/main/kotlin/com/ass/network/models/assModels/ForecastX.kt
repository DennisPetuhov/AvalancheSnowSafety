package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@OptIn(InternalSerializationApi::class)
@Serializable
data class ForecastX(
    @SerialName("details")
    val details: Details?=null,
    @SerialName("file")
    val assFile: AssFile?=null,
    @SerialName("hazard_ratings")
    val hazardRatingsResponse: HazardRatingsResponse?=null
)