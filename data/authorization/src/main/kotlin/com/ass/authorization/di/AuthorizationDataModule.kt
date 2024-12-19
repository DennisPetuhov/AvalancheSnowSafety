package com.ass.authorization.di

import com.ass.authorization.repository.AuthorizationRepository
import com.ass.authorization.repository.AuthorizationRepositoryImpl
import com.ass.core.storage.DataStoreManager
import com.ass.core.storage.di.dataStoreStorageModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

fun authorizationDataModule() = module {
    single { Dispatchers.IO }
    single { provideAuthorizationRepository(get(), get()) }
    includes(dataStoreStorageModule())
}

fun provideAuthorizationRepository(
    dataStoreManager: DataStoreManager,
    ioDispatcher: CoroutineDispatcher
): AuthorizationRepository {
    return AuthorizationRepositoryImpl(dataStoreManager, ioDispatcher)
}