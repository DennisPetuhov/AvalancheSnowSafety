package com.ass.core.storage.di


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.room.Room
import com.ass.core.storage.AssDatabase
import com.ass.core.storage.DataStoreManager
import com.ass.core.storage.dao.billetin.AssBulletinDao
import kotlinx.serialization.InternalSerializationApi
import org.koin.dsl.module
import java.io.File

const val DATA_STORE_FILE_NAME = "ass_datastore.preferences_pb"
const val DATABASE_NAME = "ass_database"

@InternalSerializationApi
fun dataStoreStorageModule() = module {
    single { provideAssDataStore(get()) }
    single { DataStoreManager(get()) }
    single { provideAssDataBase(get()) }
    single { provideAssBulletinDao(get()) }
}

@InternalSerializationApi
fun provideAssDataStore(appContext: Context): DataStore<Preferences> =
    PreferenceDataStoreFactory.create(
        produceFile = { File(appContext.filesDir, DATA_STORE_FILE_NAME) }
    )

@InternalSerializationApi
fun provideAssDataBase(context: Context): AssDatabase {
    return Room.databaseBuilder(context, AssDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration().build()
}

@InternalSerializationApi
fun provideAssBulletinDao(assDatabase: AssDatabase): AssBulletinDao = assDatabase.assBulletinDao()