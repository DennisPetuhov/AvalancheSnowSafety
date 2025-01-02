package com.ass.network.models.assModels


import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(InternalSerializationApi::class)
@Serializable
data class Forecast(
    @SerialName("description")
    val description: Description? = null,
    @SerialName("avalanche_problems")
    val avalancheProblemResponses: List<AvalancheProblemResponse>? = null,
    @SerialName("area")
    val area: String? = null,
    @SerialName("details")
    val details: Details? = null,
    @SerialName("file")
    val assFile: AssFile?=null,
    @SerialName("hazard_ratings")
    val hazardRatingsResponse: HazardRatingsResponse? = null,
    @SerialName("elevation_bands")
    val elevationBands: ElevationBands? = null,
    @SerialName("external_weather")
    val externalWeather: ExternalWeather? = null,
    @SerialName("forecast_changes")
    val forecastChanges: ForecastChanges? = null,
    @SerialName("forecaster")
    val forecaster: Forecaster? = null,
    @SerialName("formatted_time")
    val formattedTime: String?=null,
    @SerialName("formatted_valid_until")
    val formattedValidUntil: String? = null,
    @SerialName("is_current")
    val isCurrent: Boolean? = null,
    @SerialName("map")
    val map: AssMap? = null,
    @SerialName("recent_observations")
    val recentObservations: RecentObservations? = null,
    @SerialName("time")
    val time: String? = null,
    @SerialName("valid_for")
    val validFor: Int? = null,
    @SerialName("weather_forecast")
    val weatherForecast: WeatherForecast? = null
)
