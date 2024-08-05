package com.ass.network.models.assModels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Weather(
    @SerialName("weather_maps")
    val weatherMaps: WeatherMaps,
    @SerialName("weather_station_ids")
    val weatherStationIds: List<String>,
    @SerialName("wind_unit")
    val windUnit: String,
)