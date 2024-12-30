package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@OptIn(InternalSerializationApi::class)
@Serializable

data class ForecastChanges(
    @SerialName("en-UK")
    val en: String?=null
)