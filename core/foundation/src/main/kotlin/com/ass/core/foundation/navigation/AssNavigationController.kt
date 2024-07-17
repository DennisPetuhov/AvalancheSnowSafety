package com.ass.core.foundation.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusManager
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import com.ass.core.foundation.navigation.Routes.SPLASH_SCREEN
import timber.log.Timber

@Composable
fun rememberAssNavigationController(
    navController: NavHostController,
): AssNavigationController {
    return remember(navController) {
        AssNavigationController(navController)
    }
}

class AssNavigationController(private val navController: NavHostController) {
    val currentDestinations: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    fun navigate(
        destinations: AssNavDestinations?,
        route: String? = null,
        navOptionsBuilder: (NavOptionsBuilder.() -> Unit)? = null,
    ) {
        Timber.tag("Routing").d("routes  ${destinations?.route} $route")
        navController.navigate(route ?: destinations?.route ?: SPLASH_SCREEN) {
            navOptionsBuilder?.invoke(this)
        }
    }

    fun navigate(deepLink: Uri, navOptionsBuilder: (NavOptionsBuilder.() -> Unit)? = null) {
        val builder: NavOptionsBuilder.() -> Unit = {
            launchSingleTop = false
            navOptionsBuilder?.invoke(this)
        }
        try {
            navController.navigate(deepLink, navOptions(builder))
        } catch (e: Exception) {
            Timber.d("EXCEPTION: ${e.message}")
        }
    }

    private fun hideKeyBoardAnd(
        focusManager: FocusManager,
        after: (() -> Unit)?,
    ) {
        focusManager.clearFocus()
        after?.invoke()
    }

    fun popBackStack(
        hideKeyBoard: Boolean,
        focusManager: FocusManager,
        route: String? = null,
    ) {
        if (navController.previousBackStackEntry == null) {
            return
        }
        if (hideKeyBoard) {
            hideKeyBoardAnd(focusManager = focusManager) {
                navigateBack(route)
            }
        } else {
            navigateBack(route)
        }
    }

    private fun navigateBack(route: String?) {
        if (route != null) {
            navController.popBackStack(route = route, inclusive = true)
        } else {
            navController.popBackStack()
        }
    }
}