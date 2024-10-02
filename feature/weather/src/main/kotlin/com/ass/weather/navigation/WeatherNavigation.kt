package com.ass.weather.navigation

import android.net.Uri
import androidx.compose.runtime.MutableIntState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import com.ass.core.foundation.navigation.AssNavDestinations
import com.ass.core.foundation.navigation.WeatherScreenDestination
import com.ass.core.foundation.navigation.builders.avalancheSnowSafetyComposable
import com.ass.weather.ui.screens.WeatherRoute

fun NavGraphBuilder.weatherGraph(
    onBack: () -> Unit,
    navigateToDestination: (AssNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
    navigateByDeepLink: (Uri, (NavOptionsBuilder.() -> Unit)?) -> Unit,
    selectedItem: MutableIntState
) {
    avalancheSnowSafetyComposable(destinations = WeatherScreenDestination) {
        WeatherRoute(
            navigateByNavBar = { navigateToDestination(it, null, null) },
            selectedItem = selectedItem
        )
    }
}