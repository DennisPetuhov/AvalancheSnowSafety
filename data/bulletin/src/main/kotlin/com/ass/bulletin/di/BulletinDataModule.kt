package com.ass.bulletin.di

import com.ass.bulletin.repositories.bulletinrepository.BulletinRepository
import com.ass.bulletin.repositories.bulletinrepository.BulletinRepositoryImpl
import com.ass.core.storage.dao.billetin.AssBulletinDao
import com.ass.network.api.AssApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

fun bulletinDataModule() = module {
    single { provideBulletinRepository(assApi = get(), bulletinDao = get(), ioDispatcher = get()) }
}

fun provideBulletinRepository(
    assApi: AssApi,
    bulletinDao: AssBulletinDao,
    ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): BulletinRepository {
    return BulletinRepositoryImpl(assApi, bulletinDao, ioDispatcher)
}
