package com.ass.core.storage.entities.roomConverters

import androidx.room.TypeConverter
import com.ass.core.storage.entities.bulletinModels.DetailsEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class DetailsEntityConverter {
    @TypeConverter
    fun convertToJsonString(detailsEntity: DetailsEntity?): String {
        return Json.encodeToString(detailsEntity)
    }

    @TypeConverter
    fun convertToObject(json: String): DetailsEntity? {
        return Json.decodeFromString(json)
    }
}