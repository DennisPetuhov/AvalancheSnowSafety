package com.avalanche_snow_safety

import android.app.Application
import android.content.Context
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
        }
    }

    companion object {
        lateinit var appContext: Context
            private set
    }
}