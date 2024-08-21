package com.ass.core.storage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.ass.core.storage.entities.bulletinModels.ForecastEntity
import com.ass.core.storage.entities.bulletinModels.WeatherEntity
import com.ass.core.storage.entities.roomConverters.ForecastEntityConverter
import com.ass.core.storage.entities.roomConverters.WeatherEntityConverter

const val BULLETIN_TABLE = "BULLETIN TABLE"

@Entity(tableName = BULLETIN_TABLE)
@TypeConverters(WeatherEntityConverter::class, ForecastEntityConverter::class)
data class BulletinEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val currentForecast: ForecastEntity?,
//    val forecasts: List<ForecastEntity>,
    val weatherEntity: WeatherEntity,
)