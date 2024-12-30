@file:OptIn(InternalSerializationApi::class)

package com.ass.core.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.ass.core.storage.entity.AssUserEntity
import com.ass.core.storage.entity.AssUserEntity.Companion.EMPTY_USER
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


private val USER = stringPreferencesKey("user")


class DataStoreManager(private val dataStore: DataStore<Preferences>) {
    suspend fun setUser(user: AssUserEntity) {
        val userJson = Json.encodeToString(user)
        dataStore.edit { settings ->
            settings[USER] = userJson
        }
    }

    fun getUser(default: AssUserEntity = EMPTY_USER): Flow<AssUserEntity> {
        return dataStore.data.map { settings ->
            val userJson = settings[USER] ?: Json.encodeToString(default)
            Json.decodeFromString(userJson)
        }
    }
}
