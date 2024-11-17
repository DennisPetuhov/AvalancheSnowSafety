package com.ass.core.foundation.di

import com.ass.core.foundation.lifecycle.ApplicationLifecycleObserver
import com.ass.core.foundation.lifecycle.DefaultApplicationLifecycleObserver
import org.koin.dsl.module

fun foundationModule() = module { single { provideLifecycleObserver() } }

fun provideLifecycleObserver(): ApplicationLifecycleObserver = DefaultApplicationLifecycleObserver
