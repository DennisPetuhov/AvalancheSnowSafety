package com.ass.network.models.assModels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Forecast(
    @SerialName("details")
    val details: Details,
    @SerialName("file")
    val assFilePath: AssFilePath,
    @SerialName("hazard_ratings")
    val hazardRatings: HazardRatings,
)