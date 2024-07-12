package com.ass.core.foundation.navigation

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import com.ass.core.foundation.navigation.Routes.TAB_BAR
import com.ass.core.foundation.navigation.animation.AssNavAnimations
import com.ass.core.foundation.navigation.animation.SlidingAnimations
import com.ass.core.foundation.navigation.builders.avalancheSnowSafetyComposable

object TabBarDestinations : AssNavDestinations, AssNavAnimations by SlidingAnimations {
    override val route = TAB_BAR
    override val arguments: List<NamedNavArgument> = emptyList()
}

@Suppress("UNUSED_PARAMETER")
fun NavGraphBuilder.tabBarGraph(
    navigateToDestination: (
        AssNavDestinations,
        String?,
        (NavOptionsBuilder.() -> Unit)?
    ) -> Unit,
    navigateByDeepLink: (Uri, (NavOptionsBuilder.() -> Unit)?) -> Unit
) {
    avalancheSnowSafetyComposable(destinations = TabBarDestinations) { }
}