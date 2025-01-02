package com.ass.core.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ass.core.storage.dao.billetin.AssBulletinDao
import com.ass.core.storage.entity.AssBulletinEntity
import kotlinx.serialization.InternalSerializationApi

@InternalSerializationApi
@Database(entities = [AssBulletinEntity::class], version = 2, exportSchema = false)
abstract class AssDatabase: RoomDatabase() {
    abstract fun assBulletinDao(): AssBulletinDao
}