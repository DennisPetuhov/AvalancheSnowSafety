package com.ass.network.models.assModels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Details(
    @SerialName("area")
    val area: String,
    @SerialName("forecaster")
    val forecaster: String,
    @SerialName("formatted_time")
    val formattedTime: String,
    @SerialName("time")
    val time: String,
)