package com.ass.bulletin.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun BulletinRoute(
    navigateToObservationScreen: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: BulletinViewModel = koinViewModel(),
) {
    BulletinScreen(
        navigateToObservationScreen = navigateToObservationScreen,
        fetchData = viewModel::fetchData,
        modifier = modifier
    )
}

@Composable
fun BulletinScreen(
    navigateToObservationScreen: () -> Unit,
    fetchData: () -> Unit,
    modifier: Modifier,
) {
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