package com.ass.core.storage.entities.roomConverters

import androidx.room.TypeConverter
import com.ass.core.storage.entities.bulletinModels.WeatherEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class WeatherEntityConverter {
    @TypeConverter
    fun convertToJsonString(weatherEntity: WeatherEntity?): String {
        return Json.encodeToString(weatherEntity)
    }

    @TypeConverter
    fun convertToObject(json: String): WeatherEntity? {
        return Json.decodeFromString(json)
    }
}