package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@OptIn(InternalSerializationApi::class)
@Serializable
data class HighAlpine(
    @SerialName("confidence")
    val confidence: String?=null,
    @SerialName("trend")
    val trend: String?=null,
    @SerialName("value")
    val value: String?=null,
)