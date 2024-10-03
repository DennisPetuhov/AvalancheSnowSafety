package com.ass.core.designsystem.components.navbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ass.core.designsystem.theme.Paddings

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    NavigationBar(
        modifier = modifier,
        contentColor = AssNavigationDefaults.navigationContentColor(),
        tonalElevation = Paddings.paddingNone,
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
            selectedIconColor = AssNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = AssNavigationDefaults.navigationContentColor(),
            selectedTextColor = AssNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = AssNavigationDefaults.navigationContentColor(),
            indicatorColor = AssNavigationDefaults.navigationIndicatorColor(),
        ),
    )
}

object AssNavigationDefaults {
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
}
