package com.ass.core.foundation.lifecycle

import android.app.Application
import kotlinx.coroutines.flow.StateFlow

interface ApplicationLifecycleObserver {
    val lifecycleFlow: StateFlow<LifecycleEvent>
    fun initialize(application: Application)
}