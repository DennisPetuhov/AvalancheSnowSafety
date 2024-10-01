package com.ass

import android.app.Application
import com.ass.authorization.di.authorizationModule
import com.ass.bulletin.di.bulletinDataModule
import com.ass.bulletin.di.bulletinFeatureModule
import com.ass.network.di.networkModule
import com.ass.observation.di.observationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AvalancheSnowSafetyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AvalancheSnowSafetyApplication)
            modules(
                networkModule(),
                bulletinFeatureModule(),
                bulletinDataModule(),
                authorizationModule(),
                observationModule()
            )
        }
    }
}
