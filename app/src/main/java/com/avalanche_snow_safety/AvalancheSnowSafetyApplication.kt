package com.avalanche_snow_safety

import android.app.Application
import com.ass.bulletin.di.bulletinDataModule
import com.ass.bulletin.di.bulletinFeatureModule
import com.ass.core.storage.di.storageModule
import com.ass.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AvalancheSnowSafetyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AvalancheSnowSafetyApplication)
            androidLogger()
            modules(
                networkModule(),
                bulletinFeatureModule(),
                bulletinDataModule(),
                storageModule()
            )
        }
    }
}