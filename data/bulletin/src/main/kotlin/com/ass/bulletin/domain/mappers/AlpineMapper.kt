package com.ass.bulletin.domain.mappers

import com.ass.core.storage.entities.bulletinModels.AlpineEntity
import com.ass.network.models.assModels.Alpine

fun Alpine.toEntity(): AlpineEntity {
    return AlpineEntity(confidence = confidence, trend = trend, value = value)
}