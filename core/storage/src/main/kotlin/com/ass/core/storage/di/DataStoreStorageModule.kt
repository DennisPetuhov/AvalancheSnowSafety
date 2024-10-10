package com.ass.core.storage.di


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import org.koin.dsl.module
import java.io.File

const val DATA_STORE_FILE_NAME = "ass_datastore"

fun dataStoreStorageModule() = module {
    single { provideDataStore(get()) }
}

fun provideDataStore(appContext: Context): DataStore<Preferences> =
    PreferenceDataStoreFactory.create(
        produceFile = { File(appContext.filesDir, "$DATA_STORE_FILE_NAME.preferences_pb") }
    )