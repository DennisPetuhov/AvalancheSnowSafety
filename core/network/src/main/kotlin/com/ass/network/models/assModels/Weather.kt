package com.ass.network.models.assModels

data class Weather(
    val weather_maps: WeatherMaps,
    val weather_station_ids: List<String>,
    val wind_unit: String
)