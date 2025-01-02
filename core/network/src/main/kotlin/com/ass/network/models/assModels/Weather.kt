package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@OptIn(InternalSerializationApi::class)
@Serializable
data class Weather(
    @SerialName("weather_maps")
    val weatherMaps: WeatherMaps?=null,
    @SerialName("weather_station_ids")
    val weatherStationIds: List<String>?=null,
    @SerialName("wind_unit")
    val windUnit: String?=null,
)