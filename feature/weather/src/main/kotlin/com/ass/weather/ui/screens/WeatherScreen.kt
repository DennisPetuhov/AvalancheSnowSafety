package com.ass.weather.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ass.core.designsystem.components.fab.FabButtonItem
import com.ass.core.foundation.navigation.AssNavDestinations
import com.ass.fab.MultiFloatingActionButton
import com.ass.nav_bar.AssNavigationBar
import com.ass.top_bar.AssTopBar

@Composable
fun WeatherRoute(
    navigateByNavBar: (AssNavDestinations) -> Unit,
    navigateByFab: (FabButtonItem) -> Unit,
    selectedItem: MutableIntState,
    modifier: Modifier = Modifier,
) {
    WeatherScreen(
        navigateByNavBar = navigateByNavBar,
        selectedItem = selectedItem,
        navigateByFab = navigateByFab,
        modifier = modifier
    )
}

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    navigateByNavBar: (AssNavDestinations) -> Unit,
    navigateByFab: (FabButtonItem) -> Unit,
    selectedItem: MutableIntState,

    ) {
    Scaffold(topBar = { AssTopBar(onBack = {}) }, bottomBar = {
        AssNavigationBar(
            navigateByNavBar = navigateByNavBar,
            selectedItem = selectedItem
        )
    }, floatingActionButton = { MultiFloatingActionButton(onFabItemClicked = navigateByFab) }
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            Text(text = "WEATHER SCREEN")
            Button(onClick = { }) {
                Text(text = "")
            }
        }
    }
}