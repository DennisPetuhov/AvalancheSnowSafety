package com.ass.authorization.navigation

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import com.ass.authorization.ui.AuthorizationRoute
import com.ass.authorization.ui.SplashScreenRoute
import com.ass.core.foundation.navigation.AssNavDestinations
import com.ass.core.foundation.navigation.AuthorizationScreenDestination
import com.ass.core.foundation.navigation.BulletinScreenDestination
import com.ass.core.foundation.navigation.Routes.AUTHORIZATION_SCREEN
import com.ass.core.foundation.navigation.Routes.BULLETIN_SCREEN
import com.ass.core.foundation.navigation.Routes.SPLASH_SCREEN
import com.ass.core.foundation.navigation.SplashScreenDestination
import com.ass.core.foundation.navigation.animation.AssNavAnimations
import com.ass.core.foundation.navigation.animation.FadeAnimations
import com.ass.core.foundation.navigation.animation.SlidingAnimations
import com.ass.core.foundation.navigation.builders.avalancheSnowSafetyComposable

@Suppress("UNUSED_PARAMETER")
fun NavGraphBuilder.authorizationGraph(
    onBack: () -> Unit,
    navigateToDestination: (AssNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
    navigateByDeepLink: (Uri, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {
    avalancheSnowSafetyComposable(destinations = SplashScreenDestination) {
        SplashScreenRoute(navigateToAuthorizationScreen = {
            navigateToDestination(AuthorizationScreenDestination, null) {
                popUpTo(route = SPLASH_SCREEN) { inclusive = true }
            }
        })
    }
    avalancheSnowSafetyComposable(destinations = AuthorizationScreenDestination) {
        AuthorizationRoute(navigateToBulletinScreen = {
            navigateToDestination(
                BulletinScreenDestination,
                null
            ) {}
        }, onBack = {})
    }
}
