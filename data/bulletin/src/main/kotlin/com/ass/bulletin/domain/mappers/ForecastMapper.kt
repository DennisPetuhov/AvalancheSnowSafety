package com.ass.bulletin.domain.mappers

import com.ass.core.storage.entities.bulletinModels.ForecastEntity
import com.ass.network.models.assModels.Forecast

fun Forecast.toEntity(): ForecastEntity {
    return ForecastEntity(
        detailsEntity = details.toEntity(),
//        assFilePathEntity = assFilePath.toEntity(),
//        hazardRatingsEntity = hazardRatings.toEntity()
    )
}