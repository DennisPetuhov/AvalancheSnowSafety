package com.ass.core.foundation.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusManager
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.ass.core.foundation.navigation.Routes.BULLETIN
import timber.log.Timber

@Composable
fun rememberMiBankNavigationController(
    navController: NavHostController = rememberNavController()
): MiBankNavigationController {
    return remember(navController) {
        MiBankNavigationController(navController)
    }
}

class MiBankNavigationController(private val navController: NavHostController) {
    val currentDestinations: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    // val graph: NavGraph = navController.graph
    fun navigate(
        destinations: AssNavDestinations?,
        route: String? = null,
        navOptionsBuilder: (NavOptionsBuilder.() -> Unit)? = null
    ) {
        Timber.tag("Routing").d("routes  ${destinations?.route} $route")
        navController.navigate(route ?: destinations?.route ?: BULLETIN) {
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
        after: (() -> Unit)?
    ) {
        focusManager.clearFocus()
        after?.invoke()
    }

    fun popBackStack(
        hideKeyBoard: Boolean,
        focusManager: FocusManager,
        route: String? = null
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