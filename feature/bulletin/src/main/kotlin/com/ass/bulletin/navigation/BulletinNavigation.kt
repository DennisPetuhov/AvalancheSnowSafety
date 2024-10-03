package com.ass.bulletin.navigation

import android.net.Uri
import androidx.compose.runtime.MutableIntState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import com.ass.bulletin.ui.BulletinRoute
import com.ass.core.foundation.navigation.AssNavDestinations
import com.ass.core.foundation.navigation.BulletinScreenDestination
import com.ass.core.foundation.navigation.ObservationMainScreenDestination
import com.ass.core.foundation.navigation.builders.avalancheSnowSafetyComposable

@Suppress("UNUSED_PARAMETER")
fun NavGraphBuilder.bulletinGraph(
    onBack: () -> Unit,
    navigateToDestination: (AssNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
    navigateByDeepLink: (Uri, (NavOptionsBuilder.() -> Unit)?) -> Unit,
    selectedItem: MutableIntState
) {
    avalancheSnowSafetyComposable(destinations = BulletinScreenDestination) {
        BulletinRoute(
            navigateByNavBar = { navigateToDestination(it, null, null) },
            navigateByFab = { navigateToDestination(ObservationMainScreenDestination, null, null) },
            selectedItem = selectedItem
        )
    }
}