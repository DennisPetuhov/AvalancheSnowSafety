package com.ass.bulletin.ui

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
import org.koin.androidx.compose.koinViewModel

@Composable
fun BulletinRoute(
    navigateByNavBar: (AssNavDestinations) -> Unit,
    navigateByFab: (FabButtonItem) -> Unit,
    selectedItem: MutableIntState,
    modifier: Modifier = Modifier,
    viewModel: BulletinViewModel = koinViewModel(),
) {
    BulletinScreen(
        fetchData = viewModel::fetchData,
        navigateByNavBar = navigateByNavBar,
        navigateByFab = navigateByFab,
        selectedItem = selectedItem,
        modifier = modifier
    )
}

@Composable
fun BulletinScreen(
    fetchData: () -> Unit,
    modifier: Modifier = Modifier,
    navigateByNavBar: (AssNavDestinations) -> Unit,
    navigateByFab: (FabButtonItem) -> Unit,
    selectedItem: MutableIntState,
) {
    Scaffold(
        topBar = { AssTopBar(onBack = {}) },
        bottomBar = {
            AssNavigationBar(navigateByNavBar = navigateByNavBar, selectedItem = selectedItem)
        }, floatingActionButton = { MultiFloatingActionButton(onFabItemClicked = navigateByFab) }
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            Text(text = "BULLETIN SCREEN")
            Button(onClick = { fetchData() }) {
                Text(text = "Push To println Json")
            }
        }
    }
}