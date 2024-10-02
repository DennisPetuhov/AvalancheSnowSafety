package com.ass.bulletin.repositories.bulletinrepository

import com.ass.network.models.AssResponse

interface BulletinRepository {
    suspend fun fetchBulletin(): AssResponse
}