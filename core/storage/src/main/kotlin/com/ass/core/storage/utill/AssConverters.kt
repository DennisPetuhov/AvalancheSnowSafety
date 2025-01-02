package com.ass.core.storage.utill

import androidx.room.TypeConverter
import com.ass.core.storage.entity.AvalancheProblemEntity
import com.ass.core.storage.entity.HazardRatingEntity
import com.ass.core.storage.entity.IssuedAtEntity
import com.ass.core.storage.entity.RecentAvalancheEntity
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
@InternalSerializationApi
class AssConverters {
    @TypeConverter
    fun fromHazardRatingEntity(value: HazardRatingEntity): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toHazardRatingEntity(value: String): HazardRatingEntity {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromAvalancheProblemEntityList(value: List<AvalancheProblemEntity>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toAvalancheProblemEntityList(value: String): List<AvalancheProblemEntity> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromIssuedAtEntity(value: IssuedAtEntity): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toIssuedAtEntity(value: String): IssuedAtEntity {
        return Json.decodeFromString(value)
    }
    @TypeConverter
    fun fromRecentAvalancheEntityList(value: List<RecentAvalancheEntity>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toRecentAvalancheEntityList(value: String): List<RecentAvalancheEntity> {
        return Json.decodeFromString(value)
    }
}