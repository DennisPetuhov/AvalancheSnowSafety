package com.ass.bulletin.domain.mappers

import com.ass.core.storage.entities.bulletinModels.AssFilePathEntity
import com.ass.network.models.assModels.AssFilePath

fun AssFilePath.toEntity(): AssFilePathEntity {
    return AssFilePathEntity(path = path)
}