package com.ass.bulletin.domain.mappers

import com.ass.core.storage.entities.bulletinModels.WeatherEntity
import com.ass.network.models.assModels.Weather

fun Weather.toEntity(): WeatherEntity {
    return WeatherEntity(windUnit = windUnit)
}