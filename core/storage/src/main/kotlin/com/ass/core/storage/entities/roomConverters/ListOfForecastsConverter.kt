package com.ass.core.storage.entities.roomConverters

import androidx.room.TypeConverter
import com.ass.core.storage.entities.bulletinModels.ForecastEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ListOfForecastsConverter {
    @TypeConverter
    fun convertToJsonString(value: List<ForecastEntity>?): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun convertToListOf(json: String): List<ForecastEntity>? {
        return Json.decodeFromString(json)
    }
}