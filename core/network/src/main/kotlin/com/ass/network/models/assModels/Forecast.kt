package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@OptIn(InternalSerializationApi::class)
@Serializable
data class Forecast(
    @SerialName("details")
    val details: Details,
    @SerialName("file")
    val assFile: AssFile,
    @SerialName("hazard_ratings")
    val hazardRatings: HazardRatings
)