package com.ass.nav_bar

import com.ass.core.foundation.navigation.AssNavDestinations

data class BottomItem(
    val route: AssNavDestinations,
    val label: Int,
    val selectedIcon: Int,
    val icon: Int
)