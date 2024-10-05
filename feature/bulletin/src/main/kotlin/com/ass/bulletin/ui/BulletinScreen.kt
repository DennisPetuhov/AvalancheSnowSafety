package com.ass.bulletin.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ass.core.designsystem.components.fab.FabButtonItem
import com.ass.core.foundation.lifecycle.BaseActivity
import com.ass.core.foundation.navigation.AssNavDestinations
import com.ass.core.foundation.utils.getActivity
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
    val context = LocalContext.current
    val baseActivity = context.getActivity() as? BaseActivity
    val snackBarHostState = remember { SnackbarHostState() }
    Scaffold(
        topBar = { AssTopBar(onBack = {}) },
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
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
            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth(),
                text = "Current Permission Status: ${baseActivity?.currentPermissionsStatus}",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            baseActivity?.ShowPermissionSnackBar(snackBarHostState)
        }
    }
}