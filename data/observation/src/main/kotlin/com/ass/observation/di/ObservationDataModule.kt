package com.ass.observation.di

import com.ass.core.storage.DataStoreManager
import com.ass.core.storage.di.dataStoreStorageModule
import com.ass.observation.repository.ObservationRepository
import com.ass.observation.repository.ObservationRepositoryImpl
import org.koin.dsl.module

fun observationDataModule() = module { single { provideObservationRepository(get()) }
includes(dataStoreStorageModule())}

fun provideObservationRepository(dataStoreManager: DataStoreManager): ObservationRepository {
    return ObservationRepositoryImpl(dataStoreManager)
}