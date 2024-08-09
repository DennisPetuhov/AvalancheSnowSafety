package com.ass.bulletin.repositories.bulletinrepository

import com.ass.network.api.AssApi
import com.ass.network.models.AssResponse

class BulletinRepositoryImpl(private val assApi: AssApi) : BulletinRepository {
    override suspend fun fetchBulletin(): AssResponse {
        return assApi.fetchData()
    }
}