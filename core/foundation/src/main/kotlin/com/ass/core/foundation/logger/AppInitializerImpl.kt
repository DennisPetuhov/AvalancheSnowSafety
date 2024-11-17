package com.ass.core.foundation.logger

import android.app.Application
import com.ass.core.foundation.BuildConfig
import com.ass.core.foundation.lifecycle.ApplicationLifecycleObserver
import timber.log.Timber

class AppInitializerImpl(
    private val applicationLifecycleObserver: ApplicationLifecycleObserver,
) : AppInitializer {
    override fun initialize(application: Application) {
        applicationLifecycleObserver.initialize(application)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}