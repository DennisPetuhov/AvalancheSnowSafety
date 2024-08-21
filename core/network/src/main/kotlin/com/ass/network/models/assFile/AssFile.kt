package com.ass.network.models.assFile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AssFile(
    @SerialName("area")
    val area: String,
    @SerialName("avalanche_problems")
    val avalancheProblems: List<com.ass.network.models.assFile.assFile.AvalancheProblem>,
    @SerialName("description")
    val description: com.ass.network.models.assFile.assFile.DescriptionX,
    @SerialName("elevation_bands")
    val elevationBands: com.ass.network.models.assFile.assFile.ElevationBands,
    @SerialName("forecast_changes")
    val forecastChanges: com.ass.network.models.assFile.assFile.ForecastChanges,
    @SerialName("forecaster")
    val forecaster: com.ass.network.models.assFile.assFile.Forecaster,
    @SerialName("hazard_ratings")
    val hazardRatings: com.ass.network.models.assFile.assFile.HazardRatings,
    @SerialName("recent_observations")
    val recentObservations: com.ass.network.models.assFile.assFile.RecentObservations,
    @SerialName("template_version")
    val templateVersion: com.ass.network.models.assFile.assFile.TemplateVersion,
    @SerialName("time")
    val time: String,
    @SerialName("valid_for")
    val validFor: Int,
    @SerialName("weather_forecast")
    val weatherForecast: com.ass.network.models.assFile.assFile.WeatherForecast
)