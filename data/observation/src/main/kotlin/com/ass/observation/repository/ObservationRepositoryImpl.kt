package com.ass.observation.repository

import com.ass.core.storage.DataStoreManager
import kotlinx.coroutines.flow.Flow

class ObservationRepositoryImpl(private val dataStoreManager: DataStoreManager) :
    ObservationRepository {
    override suspend fun setPermissionCounter(counter: String) {
        dataStoreManager.setPermissionCounter(counter)
    }

    override suspend fun getPermissionsCounter(): Flow<String> {
        return dataStoreManager.getPermissionsCounter()
    }

    override suspend fun deletePermissionCounter() {
        dataStoreManager.deletePermissionCounter()
    }
}