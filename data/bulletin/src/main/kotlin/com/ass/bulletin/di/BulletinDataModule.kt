package com.ass.bulletin.di

import com.ass.bulletin.repositories.bulletinrepository.BulletinRepository
import com.ass.bulletin.repositories.bulletinrepository.BulletinRepositoryImpl
import com.ass.core.storage.dao.BulletinDao
import com.ass.network.api.AssApi
import org.koin.dsl.module

fun bulletinDataModule() = module {
    single { provideBulletinRepository(assApi = get(), bulletinDao = get()) }
}

fun provideBulletinRepository(assApi: AssApi, bulletinDao: BulletinDao): BulletinRepository {
    return BulletinRepositoryImpl(assApi, bulletinDao)
}
