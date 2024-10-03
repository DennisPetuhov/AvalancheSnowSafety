package com.ass.core.designsystem.components.navbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.ass.core.designsystem.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    @DrawableRes navIconRes: Int? = null,
    actionIconContentColor: Color = Color.Red,
    titleText: String,
    backgroundColor: Color = Color.White,
    onNavClick: () -> Unit,
    actions: @Composable (RowScope.() -> Unit)? = null,
    backIconModifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier
            .fillMaxWidth(),
        colors = TopAppBarColors(
            containerColor = backgroundColor,
            actionIconContentColor = actionIconContentColor,
            scrolledContainerColor = backgroundColor,
            navigationIconContentColor = backgroundColor,
            titleContentColor = Color.Black
        ),
        title = {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.icon_weather_outlined),
                    contentDescription = ""
                )
                Text(text = titleText)
            }
        },
        navigationIcon = {
            navIconRes?.let {
                IconButton(
                    modifier = backIconModifier,
                    onClick = onNavClick
                ) {
                    Image(
                        painter = painterResource(id = navIconRes),
                        contentDescription = null,
                    )
                }
            }
        },
        actions = { actions?.invoke(this) }
    )
}