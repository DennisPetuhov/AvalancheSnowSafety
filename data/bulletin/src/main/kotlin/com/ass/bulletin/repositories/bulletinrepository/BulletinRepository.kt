package com.ass.bulletin.repositories.bulletinrepository

interface BulletinRepository {
    suspend fun fetchBulletin()
}