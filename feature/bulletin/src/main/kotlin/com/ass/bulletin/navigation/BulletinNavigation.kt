package com.ass.bulletin.navigation

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import com.ass.bulletin.ui.BulletinRoute
import com.ass.core.foundation.navigation.AssNavDestinations
import com.ass.core.foundation.navigation.BulletinScreenDestination
import com.ass.core.foundation.navigation.Routes.BULLETIN_SCREEN
import com.ass.core.foundation.navigation.Routes.SPLASH_SCREEN
import com.ass.core.foundation.navigation.animation.AssNavAnimations
import com.ass.core.foundation.navigation.animation.FadeAnimations
import com.ass.core.foundation.navigation.animation.SlidingAnimations
import com.ass.core.foundation.navigation.builders.avalancheSnowSafetyComposable

@Suppress("UNUSED_PARAMETER")
fun NavGraphBuilder.bulletinGraph(
    onBack: () -> Unit,
    navigateToDestination: (AssNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
    navigateByDeepLink: (Uri, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {
    avalancheSnowSafetyComposable(destinations = BulletinScreenDestination) {
        BulletinRoute(navigateToObservationScreen = {})
    }
}