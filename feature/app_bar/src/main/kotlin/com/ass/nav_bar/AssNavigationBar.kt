package com.ass.nav_bar

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.ass.core.designsystem.AssIcons
import com.ass.core.designsystem.R
import com.ass.core.designsystem.components.navbar.MainNavigationBar
import com.ass.core.designsystem.components.navbar.AssNavigationBarItem
import com.ass.core.foundation.navigation.AssNavDestinations
import com.ass.core.foundation.navigation.BulletinScreenDestination
import com.ass.core.foundation.navigation.KnowledgeScreenDestination
import com.ass.core.foundation.navigation.WeatherScreenDestination

@Composable
fun AssNavigationBar(
    navigateByNavBar: (AssNavDestinations) -> Unit,
    selectedItem: MutableIntState,
) {
    MainNavigationBar {
        bottomItems.forEachIndexed { index, item ->
            AssNavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = stringResource(id = item.label),
                    )
                },
                selectedIcon = {
                    Icon(
                        painter = painterResource(id = item.selectedIcon),
                        contentDescription = stringResource(id = item.label),
                    )
                },
                label = { Text(stringResource(id = item.label)) },
                selected = selectedItem.intValue == index,
                onClick = { selectedItem.intValue = index
                    navigateByNavBar(item.route)},
            )
        }
    }
}

val bottomItems = listOf(
    BottomItem(WeatherScreenDestination,R.string.weather, AssIcons.weather, AssIcons.weatherOutlined),
    BottomItem(BulletinScreenDestination,R.string.bulletin, AssIcons.bulletin, AssIcons.bulletinOutlined),
    BottomItem(KnowledgeScreenDestination,R.string.knowledge, AssIcons.knowledge, AssIcons.knowledgeOutlined)
)