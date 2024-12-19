package com.ass.authorization.repository

import com.ass.authorization.domain.mappers.toDomain
import com.ass.authorization.domain.mappers.toEntity
import com.ass.authorization.domain.models.AssUser
import com.ass.core.storage.DataStoreManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class AuthorizationRepositoryImpl(
    private val dataStoreManager: DataStoreManager,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) :
    AuthorizationRepository {
    override suspend fun setUser(user: AssUser) =
        withContext(ioDispatcher) { dataStoreManager.setUser(user.toEntity()) }

    override suspend fun getUser(): Flow<AssUser> = withContext(ioDispatcher) {
        dataStoreManager.getUser().map { it.toDomain() }
    }
}