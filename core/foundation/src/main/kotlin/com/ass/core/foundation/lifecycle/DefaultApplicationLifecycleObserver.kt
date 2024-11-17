package com.ass.core.foundation.lifecycle

import android.app.Activity
import android.app.Application
import android.os.Bundle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

object DefaultApplicationLifecycleObserver :
    Application.ActivityLifecycleCallbacks, ApplicationLifecycleObserver {

    private val _lifecycleFlow: MutableStateFlow<LifecycleEvent> =
        MutableStateFlow(LifecycleEvent.OnStopped)

    override val lifecycleFlow: StateFlow<LifecycleEvent> get() = _lifecycleFlow

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        _lifecycleFlow.update { LifecycleEvent.OnCreated }
    }

    override fun onActivityStarted(p0: Activity) {
        _lifecycleFlow.update { LifecycleEvent.OnStarted }
    }

    override fun onActivityResumed(p0: Activity) {
        _lifecycleFlow.update { LifecycleEvent.OnResumed }
    }

    override fun onActivityPaused(p0: Activity) {
        _lifecycleFlow.update { LifecycleEvent.OnPaused }
    }

    override fun onActivityStopped(p0: Activity) {
        _lifecycleFlow.update { LifecycleEvent.OnStopped }
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        _lifecycleFlow.update { LifecycleEvent.OnSaveInstanceState }
    }

    override fun onActivityDestroyed(p0: Activity) {
        _lifecycleFlow.update { LifecycleEvent.OnDestroyed }
    }

    override fun initialize(application: Application) {
        application.registerActivityLifecycleCallbacks(this)
    }
}