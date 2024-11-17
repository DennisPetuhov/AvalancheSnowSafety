package com.ass.core.foundation.logger

import android.app.Application

interface AppInitializer {
    fun initialize(application: Application)
}