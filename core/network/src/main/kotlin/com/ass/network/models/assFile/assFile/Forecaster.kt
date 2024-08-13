package com.ass.network.models.assFile.assFile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Forecaster(
    @SerialName("name")
    val name: String,
    @SerialName("organisation")
    val organisation: String?,
)