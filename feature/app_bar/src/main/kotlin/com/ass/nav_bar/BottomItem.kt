package com.ass.nav_bar

import androidx.compose.ui.graphics.vector.ImageVector
import com.ass.core.foundation.navigation.AssNavDestinations

data class BottomItem(
    val route: AssNavDestinations,
    val label: Int,
    val selectedIcon: ImageVector,
    val icon: ImageVector
)