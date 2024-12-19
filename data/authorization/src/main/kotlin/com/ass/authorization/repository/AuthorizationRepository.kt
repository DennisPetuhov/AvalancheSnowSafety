package com.ass.authorization.repository

import com.ass.authorization.domain.models.AssUser
import com.ass.core.storage.entity.AssUserEntity
import kotlinx.coroutines.flow.Flow

interface AuthorizationRepository {
    suspend fun setUser(user: AssUser)
    suspend fun getUser(): Flow<AssUser>
}