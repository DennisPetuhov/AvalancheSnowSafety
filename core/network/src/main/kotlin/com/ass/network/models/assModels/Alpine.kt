package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@OptIn(InternalSerializationApi::class)
@Serializable
data class Alpine(
    @SerialName("confidence")
    val confidence: String?,
    @SerialName("trend")
    val trend: String?,
    @SerialName("value")
    val value: String?,
)