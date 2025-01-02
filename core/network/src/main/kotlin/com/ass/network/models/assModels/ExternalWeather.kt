package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(InternalSerializationApi::class)
@Serializable
data class ExternalWeather(
    @SerialName("weather_maps")
    val weatherMaps: WeatherMaps?=null,
    @SerialName("wind_unit")
    val windUnit: String?=null
)
