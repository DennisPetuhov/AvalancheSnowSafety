package com.avalanche_snow_safety

import android.app.Application
import android.content.Context
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
        appContext = applicationContext
        startKoin {
            androidLogger()
            androidContext(this@AvalancheSnowSafetyApplication)
            modules(
                networkModule(),
                bulletinFeatureModule(),
                bulletinDataModule(),
                storageModule()
            )
        }
    }

    companion object {
        lateinit var appContext: Context
            private set
    }
}