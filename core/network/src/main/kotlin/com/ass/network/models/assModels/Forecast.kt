package com.ass.network.models.assModels

data class Forecast(
    val details: Details,
    val `file`: File,
    val hazard_ratings: HazardRatings
)