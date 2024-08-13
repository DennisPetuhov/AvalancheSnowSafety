package com.ass.core.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ass.core.storage.dao.BulletinDao
import com.ass.core.storage.entities.BulletinEntity

@Database(entities = [BulletinEntity::class], version = 2, exportSchema = false)
abstract class AssDatabase : RoomDatabase() {
    abstract fun bulletinDao(): BulletinDao
}