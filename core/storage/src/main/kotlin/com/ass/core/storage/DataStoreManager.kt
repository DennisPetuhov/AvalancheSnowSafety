package com.ass.core.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val COUNTER = stringPreferencesKey("counter")

class DataStoreManager(private val dataStore: DataStore<Preferences>) {
    suspend fun setPermissionCounter(counter: String) {
        dataStore.edit { settings ->
            settings[COUNTER] = counter
        }
    }

     fun getPermissionsCounter(default: String = ""): Flow<String> {
        println("suspend Get Permissions Counter DATASTOREMANAGER")
        val currentCounterValue = dataStore.data.map { settings ->
            settings[COUNTER] ?: default
        }
        return currentCounterValue
    }

    suspend fun deletePermissionCounter() {
        println("Delete Permission Counter")
        dataStore.edit { settings ->
            settings.remove(COUNTER)
        }
    }
}