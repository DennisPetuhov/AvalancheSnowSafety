package com.ass.bulletin.repositories.bulletinrepository

import com.ass.bulletin.domain.mappers.toEntity
import com.ass.core.storage.dao.BulletinDao
import com.ass.network.api.AssApi

class BulletinRepositoryImpl(private val assApi: AssApi, private val bulletinDao: BulletinDao) :
    BulletinRepository {
    override suspend fun fetchBulletin() {
        val response = assApi.fetchData().toEntity()
        bulletinDao.insertForecast(response)
    }
}