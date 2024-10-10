package com.ass.core.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val COUNTER = intPreferencesKey("counter")

class DataStoreManager(private val dataStore: DataStore<Preferences>) {
    suspend fun increasePermissionCounter(default: Int = 0) {
        dataStore.edit { settings ->
            val currentCounterValue = settings[COUNTER] ?: default
            settings[COUNTER] = currentCounterValue + 1
        }
    }

    suspend fun getPermissionsCounter(default: Int = 0): Flow<Int> {
        val currentCounterValue = dataStore.data.map { settings ->
            settings[COUNTER] ?: default
        }
        return currentCounterValue
    }
}