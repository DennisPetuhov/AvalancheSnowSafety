package com.ass.observation.repository

import kotlinx.coroutines.flow.Flow

interface ObservationRepository {
    suspend fun setPermissionCounter(counter: String)
    suspend fun getPermissionsCounter(): Flow<String>
    suspend fun deletePermissionCounter()
}