package com.ass.observation.repository

import kotlinx.coroutines.flow.Flow

interface ObservationRepository {
    suspend fun increasePermissionCounter()
    suspend fun getPermissionsCounter(): Flow<Int>
}