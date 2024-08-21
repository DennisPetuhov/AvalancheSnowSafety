package com.ass.bulletin.domain.mappers

import com.ass.core.storage.entities.bulletinModels.OverallEntity
import com.ass.network.models.assModels.Overall

fun Overall.toEntity(): OverallEntity {
    return OverallEntity(confidence, trend, value)
}