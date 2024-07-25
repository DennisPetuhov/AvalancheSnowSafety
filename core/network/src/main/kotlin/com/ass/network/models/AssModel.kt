package com.ass.network.models

import com.ass.network.models.assModels.Forecast
import com.ass.network.models.assModels.Weather

data class AssModel(
    val current_forecast: Any,
    val errors: List<Any>,
    val forecasts: List<Forecast>,
    val weather: Weather
)