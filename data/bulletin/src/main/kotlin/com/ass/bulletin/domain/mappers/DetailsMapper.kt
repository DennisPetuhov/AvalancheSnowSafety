package com.ass.bulletin.domain.mappers

import com.ass.core.storage.entities.bulletinModels.DetailsEntity
import com.ass.network.models.assModels.Details

fun Details.toEntity(): DetailsEntity {
    return DetailsEntity(
        area = area,
        forecaster = forecaster,
        formattedTime = formattedTime,
        time = time
    )
}