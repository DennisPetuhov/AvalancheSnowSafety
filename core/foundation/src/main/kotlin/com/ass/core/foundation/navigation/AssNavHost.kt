package com.ass.core.foundation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.ass.core.foundation.navigation.animation.AssNavAnimations
import com.ass.core.foundation.navigation.animation.SlidingAnimations

@Composable
fun AssNavHost(
    navController: NavHostController,
    startDestination: AssNavDestinations,
    animations: AssNavAnimations = SlidingAnimations,
    builder: NavGraphBuilder.() -> Unit,
) {
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = startDestination.route,
        enterTransition = animations.enterTransition,
        exitTransition = animations.exitTransition,
        popEnterTransition = animations.popEnterTransition,
        popExitTransition = animations.popExitTransition,
        builder = builder
    )
}