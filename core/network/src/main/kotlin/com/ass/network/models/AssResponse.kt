package com.ass.network.models

import com.ass.network.models.assModels.Forecast
import com.ass.network.models.assModels.Weather
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AssResponse(
    @SerialName("current_forecast")
    val currentForecast: Forecast?,
    @SerialName("forecasts")
    val forecasts: List<Forecast>,
    @SerialName("weather")
    val weather: Weather,
    @SerialName("errors")
    val errors: List<String> = emptyList(),
)