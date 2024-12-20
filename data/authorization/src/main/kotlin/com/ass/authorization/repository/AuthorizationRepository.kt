package com.ass.authorization.repository

import com.ass.authorization.domain.models.AssUser
import kotlinx.coroutines.flow.Flow

interface AuthorizationRepository {
    suspend fun setUser(user: AssUser)
    suspend fun getUser(): Flow<AssUser>
}