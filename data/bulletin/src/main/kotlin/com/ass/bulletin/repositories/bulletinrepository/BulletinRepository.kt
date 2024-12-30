package com.ass.bulletin.repositories.bulletinrepository

import com.ass.bulletin.domain.models.AssBulletin
import kotlinx.coroutines.flow.Flow

interface BulletinRepository {
    suspend fun fetchBulletin()
    suspend fun getActualBulletin(): Flow<AssBulletin>
}