package com.ass.core.designsystem.components.navbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.ass.core.designsystem.components.icons.AssIcons
import com.ass.core.designsystem.theme.AssPaddings
import com.ass.core.designsystem.theme.AssTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssTopBar(
    titleText: Int,
    onNavClick: () -> Unit,
    modifier: Modifier = Modifier,
    navIcon: ImageVector? = null,
    logoIcon : ImageVector? = AssIcons.AssLogo,
    backgroundColor: Color = AssTheme.colorScheme.background,
    actionIconContentColor: Color = Color.Transparent,
    actions: @Composable (RowScope.() -> Unit)? = null,
) {
    CenterAlignedTopAppBar(
        modifier = modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor,
            actionIconContentColor = actionIconContentColor,
            titleContentColor = AssTheme.colorScheme.primary
        ),
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AssPaddings.padding16dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                logoIcon?.let {
                    Icon(
                        imageVector = it, contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = stringResource(titleText),
                    style = AssTheme.typography.titleMedium,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        },
        navigationIcon = {
            navIcon?.let {
                IconButton(onClick = onNavClick) {
                    Image(imageVector = navIcon, contentDescription = null)
                }
            }
        },
        actions = { actions?.invoke(this) }
    )
}