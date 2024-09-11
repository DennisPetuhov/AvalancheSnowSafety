package com.ass.authorization.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SplashScreenRoute(
    navigateToAuthorizationScreen: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SplashScreen(navigateToAuthorizationScreen = navigateToAuthorizationScreen, modifier = modifier)
}

@Composable
fun SplashScreen(navigateToAuthorizationScreen: () -> Unit, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "SPLASH SCREEN")
        Button(onClick = { navigateToAuthorizationScreen() }) {
            Text(text = "TO AUTH SCREEN")
        }
    }
}