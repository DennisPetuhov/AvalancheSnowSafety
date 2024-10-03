package com.ass.top_bar

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ass.core.designsystem.R
import com.ass.core.designsystem.components.navbar.TopBar

@Composable
fun AssTopBar(onBack: () -> Unit) {
    TopBar(
//        modifier = Modifier.background(color = colorScheme.primary),
        navIconRes = R.drawable.icon_arrow_back,
        onNavClick = onBack,
        titleText = stringResource(R.string.avalanche_ge),
    )
}