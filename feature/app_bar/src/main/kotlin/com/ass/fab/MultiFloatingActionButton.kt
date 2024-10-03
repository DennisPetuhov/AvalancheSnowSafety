package com.ass.fab

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ass.core.designsystem.AssIcons
import com.ass.core.designsystem.R
import com.ass.core.designsystem.components.fab.AssMultiFAB
import com.ass.core.designsystem.components.fab.FabButtonItem
import com.ass.core.designsystem.components.fab.FabButtonMain
import com.ass.core.designsystem.components.fab.fabButtonSub

@Composable
fun MultiFloatingActionButton(onFabItemClicked: (FabButtonItem) -> Unit) {
    AssMultiFAB(
        items = listOf(
            FabButtonItem(
                iconRes = AssIcons.weatherOutlinedFab,
                label = stringResource(id = R.string.weather_fab)
            ),
            FabButtonItem(
                iconRes = AssIcons.avalancheOutlinedFab,
                label = stringResource(id = R.string.avalanche_fab)
            ),
            FabButtonItem(
                iconRes = AssIcons.snowPackConditionsOutlinedFab,
                label = stringResource(id = R.string.snowpack_fab)
            ),

            ),
        onFabItemClicked = { onFabItemClicked(it) },
        fabIcon = FabButtonMain(),
        fabOption = fabButtonSub()
    )
}