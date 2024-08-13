package com.ass.bulletin.domain.mappers

import com.ass.core.storage.entities.bulletinModels.SubAlpineEntity
import com.ass.network.models.assModels.SubAlpine

fun SubAlpine.toEntity(): SubAlpineEntity {
    return SubAlpineEntity(confidence = confidence, trend = trend, value = value)
}