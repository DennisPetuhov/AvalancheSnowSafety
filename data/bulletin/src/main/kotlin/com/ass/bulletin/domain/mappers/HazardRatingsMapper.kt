package com.ass.bulletin.domain.mappers

import com.ass.core.storage.entities.bulletinModels.HazardRatingsEntity
import com.ass.network.models.assModels.HazardRatings

fun HazardRatings.toEntity(): HazardRatingsEntity {
    return HazardRatingsEntity(
        alpineEntity = alpine?.toEntity(),
        highAlpineEntity = highAlpine?.toEntity(),
        overallEntity = overall?.toEntity(),
        subAlpineEntity = subAlpine?.toEntity()
    )
}