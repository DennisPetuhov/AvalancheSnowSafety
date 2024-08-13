package com.ass.core.storage.entities.roomConverters

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ListOfStringsConverter {
    @TypeConverter
    fun convertToJsonString(value: List<String>?): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun convertToListOf(json: String): List<String>? {
        return Json.decodeFromString(json)
    }
}