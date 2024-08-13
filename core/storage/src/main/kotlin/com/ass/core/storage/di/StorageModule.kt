package com.ass.core.storage.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.ass.core.storage.AssDatabase
import com.ass.core.storage.dao.BulletinDao
import org.koin.core.module.Module
import org.koin.dsl.module

const val DATABASE_NAME = "avalanche_snow_safety_database"
fun storageModule() = module { room() }

private fun Module.room() {
    single { provideAssDatabase(get()) }
    single { provideBulletinDao(get()) }
}

fun provideAssDatabase(context: Context): AssDatabase {
    return databaseBuilder(
        context,
        AssDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()
}

fun provideBulletinDao(assDatabase: AssDatabase): BulletinDao {
    return assDatabase.bulletinDao()
}