package com.ass.network.models.assModels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@kotlinx.serialization.InternalSerializationApi
@Serializable
data class Overall(
    @SerialName("confidence")
    //увереность в прогнозе
    val confidence: String?,
    @SerialName("trend")
    //не поазываеться в общем
    val trend: String?,
    @SerialName("value")
    val value: String?
)