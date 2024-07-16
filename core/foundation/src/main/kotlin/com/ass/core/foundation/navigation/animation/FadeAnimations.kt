package com.ass.core.foundation.navigation.animation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavBackStackEntry

object FadeAnimations : AssNavAnimations {
    override val enterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition
        get() = { fadeIn() }
    override val exitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition
        get() = { fadeOut() }
    override val popEnterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition
        get() = { fadeIn() }
    override val popExitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition
        get() = { fadeOut() }
}