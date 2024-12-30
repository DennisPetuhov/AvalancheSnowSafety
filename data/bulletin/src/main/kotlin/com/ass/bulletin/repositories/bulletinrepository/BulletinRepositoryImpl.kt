package com.ass.bulletin.repositories.bulletinrepository

import com.ass.bulletin.domain.mappers.toDomain
import com.ass.bulletin.domain.mappers.toEntity
import com.ass.bulletin.domain.models.AssBulletin
import com.ass.core.storage.dao.billetin.AssBulletinDao
import com.ass.network.api.AssApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class BulletinRepositoryImpl(
    private val assApi: AssApi,
    private val bulletinDao: AssBulletinDao,
    private val ioDispatcher: CoroutineDispatcher
) :
    BulletinRepository {
    override suspend fun fetchBulletin() {
        withContext(ioDispatcher) {
            val data = assApi.fetchData()
            data.let { bulletinDao.insert(it.toEntity()) }
        }
    }

    override suspend fun getActualBulletin(): Flow<AssBulletin> = withContext(ioDispatcher) {
        bulletinDao.getBulletin().map { it.toDomain() }
    }
}