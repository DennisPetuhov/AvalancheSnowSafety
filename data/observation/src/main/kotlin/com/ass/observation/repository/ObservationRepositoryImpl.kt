package com.ass.observation.repository

import com.ass.core.storage.DataStoreManager
import kotlinx.coroutines.flow.Flow

class ObservationRepositoryImpl(private val dataStoreManager: DataStoreManager) :
    ObservationRepository {
    override suspend fun increasePermissionCounter() {
        dataStoreManager.increasePermissionCounter()
    }

    override suspend fun getPermissionsCounter(): Flow<Int> {
        return dataStoreManager.getPermissionsCounter()
    }
}