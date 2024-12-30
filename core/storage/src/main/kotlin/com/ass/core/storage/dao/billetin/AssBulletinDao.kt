package com.ass.core.storage.dao.billetin

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ass.core.storage.entity.AssBulletinEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.InternalSerializationApi

@InternalSerializationApi
@Dao
interface AssBulletinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bulletin: AssBulletinEntity)

    @Query("SELECT * FROM AssBulletinEntity WHERE id = :id")
    suspend fun getBulletinById(id: Int): AssBulletinEntity?


    @Query("SELECT * FROM AssBulletinEntity")
    fun getBulletin(): Flow<AssBulletinEntity>
}