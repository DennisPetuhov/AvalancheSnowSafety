package com.ass.ui.app


import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.compose.rememberNavController
import com.ass.authorization.navigation.authorizationGraph
import com.ass.bulletin.navigation.bulletinGraph
import com.ass.core.foundation.navigation.AssNavHost
import com.ass.core.foundation.navigation.SplashScreenDestination
import com.ass.core.foundation.navigation.rememberAssNavigationController
import com.ass.core.foundation.navigation.tabBarGraph
import com.ass.ui.theme.AvalancheSnowSafetyTheme

@Composable
fun AvalancheSnowSafetyApp() {
    AvalancheSnowSafetyTheme {
        val animatedNavController = rememberNavController()
        val assNavController =
            rememberAssNavigationController(navController = animatedNavController)
        val focusManager = LocalFocusManager.current
        AssNavHost(
            navController = animatedNavController,
            startDestination = remember { SplashScreenDestination }) {
            authorizationGraph(
                onBack = {},
                navigateToDestination = assNavController::navigate,
                navigateByDeepLink = assNavController::navigate
            )
            bulletinGraph(
                onBack = {
                    assNavController.popBackStack(
                        hideKeyBoard = true,
                        focusManager = focusManager
                    )
                },
                navigateToDestination = assNavController::navigate,
                navigateByDeepLink = assNavController::navigate,
            )
            tabBarGraph(
                navigateToDestination = assNavController::navigate,
                navigateByDeepLink = assNavController::navigate,
            )
        }
    }
}