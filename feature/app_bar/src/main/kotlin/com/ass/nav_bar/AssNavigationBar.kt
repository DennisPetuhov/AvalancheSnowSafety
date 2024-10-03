package com.ass.nav_bar

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.res.stringResource
import com.ass.core.designsystem.AssIcons
import com.ass.core.designsystem.R
import com.ass.core.designsystem.components.navbar.AssNavigationBarItem
import com.ass.core.designsystem.components.navbar.BottomNavBar
import com.ass.core.foundation.navigation.AssNavDestinations
import com.ass.core.foundation.navigation.BulletinScreenDestination
import com.ass.core.foundation.navigation.KnowledgeScreenDestination
import com.ass.core.foundation.navigation.WeatherScreenDestination

@Composable
fun AssNavigationBar(
    navigateByNavBar: (AssNavDestinations) -> Unit,
    selectedItem: MutableIntState,
) {
    BottomNavBar {
        getBottomItems().forEachIndexed { index, item ->
            AssNavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(id = item.label),
                    )
                },
                selectedIcon = {
                    Icon(
                        imageVector = item.selectedIcon,
                        contentDescription = stringResource(id = item.label),
                    )
                },
                label = { Text(stringResource(id = item.label)) },
                selected = selectedItem.intValue == index,
                onClick = {
                    selectedItem.intValue = index
                    navigateByNavBar(item.route)
                },
            )
        }
    }
}

@Composable
fun getBottomItems(): List<BottomItem> {
    return listOf(
        BottomItem(
            WeatherScreenDestination,
            R.string.weather,
            AssIcons.weather,
            AssIcons.weatherOutlined
        ),
        BottomItem(
            BulletinScreenDestination,
            R.string.bulletin,
            AssIcons.bulletin,
            AssIcons.bulletinOutlined
        ),
        BottomItem(
            KnowledgeScreenDestination,
            R.string.knowledge,
            AssIcons.knowledge,
            AssIcons.knowledgeOutlined
        )
    )
}