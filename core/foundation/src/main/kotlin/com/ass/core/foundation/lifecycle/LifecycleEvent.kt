package com.ass.core.foundation.lifecycle

sealed class LifecycleEvent {
    data object OnPaused : LifecycleEvent()
    data object OnResumed : LifecycleEvent()
    data object OnStarted : LifecycleEvent()
    data object OnDestroyed : LifecycleEvent()
    data object OnSaveInstanceState : LifecycleEvent()
    data object OnStopped : LifecycleEvent()
    data object OnCreated : LifecycleEvent()
}