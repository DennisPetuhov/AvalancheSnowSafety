package com.ass.core.designsystem.components.navbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ass.core.designsystem.theme.AssTheme
import com.ass.core.designsystem.theme.AssPaddings

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    NavigationBar(
        modifier = modifier,
//        contentColor = AssNavigationNarColorsDefaults.navigationContentColor(),
        contentColor = AssTheme.colorScheme.avalancheDangerLevel2,
        containerColor =  AssNavigationNarColorsDefaults.navigationContentColor(),
        tonalElevation = AssPaddings.padding8dp,
        content = content,
    )
}

@Composable
fun RowScope.AssNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    alwaysShowLabel: Boolean = true,
    icon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit = icon,
    label: @Composable (() -> Unit)? = null,
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = AssNavigationNarColorsDefaults.selectedIconColor(),
            unselectedIconColor = AssNavigationNarColorsDefaults.unselectedIconAndTextColor(),
            selectedTextColor = AssNavigationNarColorsDefaults.selectedItemAndTextColor(),
            unselectedTextColor = AssNavigationNarColorsDefaults.unselectedIconAndTextColor(),
            indicatorColor = AssNavigationNarColorsDefaults.selectedItemAndTextColor(),

        ),
    )
}
object AssNavigationNarColorsDefaults {
    @Composable
    fun navigationContentColor() = AssTheme.colorScheme.primary
    @Composable
    fun navigationContainerColor() = AssTheme.colorScheme.primary
    @Composable
    fun selectedIconColor() = AssTheme.colorScheme.primary
    @Composable
    fun unselectedIconAndTextColor() = AssTheme.colorScheme.tertiary
    @Composable
    fun selectedItemAndTextColor() = AssTheme.colorScheme.background
    @Composable
    fun unselectedIndicatorColor() = AssTheme.colorScheme.secondary
}
