package com.ass.authorization.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.ass.core.designsystem.R
import com.ass.core.designsystem.components.icons.AssIcons
import com.ass.core.designsystem.theme.AssElevation
import com.ass.core.designsystem.theme.AssPaddings
import com.ass.core.designsystem.theme.AssTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreenRoute(
    navigateToAuthorizationScreen: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SplashScreenViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    SplashScreen(
        navigateToAuthorizationScreen = navigateToAuthorizationScreen,
        uiState = uiState,
        modifier = modifier
    )
}

@Composable
fun SplashScreen(
    navigateToAuthorizationScreen: () -> Unit,
    uiState: SplashScreenUiState,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(uiState.isLoading) {
        if (!uiState.isLoading) {
            navigateToAuthorizationScreen()
        }
    }
    Surface(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.fillMaxSize()
            ) {
                Image(
                    AssIcons.AssLogoSplash,
                    contentDescription = stringResource(R.string.splash_logo),
                    modifier = Modifier
                        .clip(CircleShape)
                        .shadow(
                            elevation = AssElevation.elevation16dp,
                            shape = CircleShape,
                            spotColor = AssTheme.colorScheme.primary,
                            ambientColor = AssTheme.colorScheme.secondary
                        )
                )
                Spacer(modifier = Modifier.padding(AssPaddings.padding16dp))
                Text(
                    text = stringResource(R.string.avalanche_ge),
                    style = AssTheme.typography.displayMedium.copy(
                        color = AssTheme.colorScheme.avalancheDangerLevel3,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
            Text(
                text = stringResource(R.string.in_snow_we_trust),
                style = AssTheme.typography.bodyLarge.copy(color = AssTheme.colorScheme.primary),
                modifier = Modifier.padding(bottom = AssPaddings.padding32dp)
            )
        }
    }
}