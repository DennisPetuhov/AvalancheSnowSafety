package com.ass.network.models

import com.ass.network.models.assModels.CurrentForecast
import com.ass.network.models.assModels.ForecastX
import com.ass.network.models.assModels.Weather
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(InternalSerializationApi::class)
@Serializable
data class AssResponse(
    @SerialName("current_forecast")
    val currentForecast:  CurrentForecast?=null,
    @SerialName("forecasts")
    val forecastX: List<ForecastX>?=null,
    @SerialName("weather")
    val weather: Weather?=null,
    @SerialName("errors")
    val errors: List<String> = emptyList()
)