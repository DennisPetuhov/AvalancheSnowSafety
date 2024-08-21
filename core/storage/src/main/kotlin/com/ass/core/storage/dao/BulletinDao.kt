package com.ass.core.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.ass.core.storage.entities.BulletinEntity

@Dao
interface BulletinDao {
//    @Query("SELECT * FROM `AVALANCHE SNOW SAFETY ENTITY`")
//    suspend fun getCurrentForecast(): Flow<AssEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecast(entity: BulletinEntity)
}