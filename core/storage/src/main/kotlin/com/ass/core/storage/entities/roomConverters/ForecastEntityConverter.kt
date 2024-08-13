package com.ass.core.storage.entities.roomConverters

import androidx.room.TypeConverter
import com.ass.core.storage.entities.bulletinModels.ForecastEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ForecastEntityConverter {
    @TypeConverter
    fun convertToJsonString(forecastEntity: ForecastEntity?): String {
        return Json.encodeToString(forecastEntity)
    }

    @TypeConverter
    fun convertToObject(json: String): ForecastEntity? {
        return Json.decodeFromString(json)
    }
}