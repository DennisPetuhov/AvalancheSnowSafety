package com.ass.observation.navigation

import android.net.Uri
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import com.ass.core.foundation.navigation.AssNavDestinations
import com.ass.core.foundation.navigation.ObservationMainScreenDestination
import com.ass.core.foundation.navigation.builders.avalancheSnowSafetyComposable
import com.ass.observation.ui.screens.main.ObservationMainScreenRoute

@Suppress("UNUSED_PARAMETER")
fun NavGraphBuilder.observationGraph(
    onBack: () -> Unit,
    navigateToDestination: (AssNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
    navigateByDeepLink: (Uri, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {
    avalancheSnowSafetyComposable(destinations = ObservationMainScreenDestination) {
        ObservationMainScreenRoute(navigateToCommonScreen = {}, onBack = {})
    }
}