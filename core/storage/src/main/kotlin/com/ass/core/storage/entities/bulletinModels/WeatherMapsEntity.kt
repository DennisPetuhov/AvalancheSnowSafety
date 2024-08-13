package com.ass.core.storage.entities.bulletinModels

import kotlinx.serialization.Serializable

@Serializable
data class WeatherMapsEntity(
    val meteoBlue: MeteoblueEntity,
)