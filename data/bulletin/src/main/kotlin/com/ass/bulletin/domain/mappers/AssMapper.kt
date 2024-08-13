package com.ass.bulletin.domain.mappers

import com.ass.core.storage.entities.BulletinEntity
import com.ass.network.models.AssResponse


fun AssResponse.toEntity(): BulletinEntity {
    return BulletinEntity(
        weatherEntity = weather.toEntity(),
        currentForecast = forecasts[1].toEntity()
    )
}