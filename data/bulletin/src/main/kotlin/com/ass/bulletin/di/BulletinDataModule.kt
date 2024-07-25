package com.ass.bulletin.di

import com.ass.bulletin.repositories.bulletinrepository.BulletinRepository
import com.ass.bulletin.repositories.bulletinrepository.BulletinRepositoryImpl
import com.ass.network.api.AssApi
import org.koin.dsl.module

fun bulletinDataModule() = module {
    single { provideBulletinRepository(assApi = get()) }
}

fun provideBulletinRepository(assApi: AssApi): BulletinRepository {
    return BulletinRepositoryImpl(assApi)
}
