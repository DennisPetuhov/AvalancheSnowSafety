package com.ass.di

import com.ass.core.foundation.lifecycle.ApplicationLifecycleObserver
import com.ass.core.foundation.logger.AppInitializer
import com.ass.core.foundation.logger.AppInitializerImpl
import org.koin.dsl.module

fun appModule() = module {
    single { provideAppInitializer(get()) }
}

fun provideAppInitializer(applicationLifecycleObserver: ApplicationLifecycleObserver): AppInitializer {
    return AppInitializerImpl(applicationLifecycleObserver)
}
