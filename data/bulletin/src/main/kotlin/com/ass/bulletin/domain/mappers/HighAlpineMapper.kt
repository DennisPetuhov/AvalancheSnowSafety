package com.ass.bulletin.domain.mappers

import com.ass.core.storage.entities.bulletinModels.HighAlpineEntity
import com.ass.network.models.assModels.HighAlpine

fun HighAlpine.toEntity(): HighAlpineEntity {
    return HighAlpineEntity(confidence = confidence, trend = trend, value = value)
}