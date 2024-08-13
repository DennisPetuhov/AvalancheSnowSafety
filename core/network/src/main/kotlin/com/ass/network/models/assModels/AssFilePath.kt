package com.ass.network.models.assModels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AssFilePath(
    @SerialName("path")
    val path: String
)