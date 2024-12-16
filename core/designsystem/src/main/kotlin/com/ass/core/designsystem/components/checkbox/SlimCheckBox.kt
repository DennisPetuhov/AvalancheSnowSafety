package com.ass.core.designsystem.components.checkbox

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.ass.core.designsystem.R
import com.ass.core.designsystem.components.icons.AssIcons
import com.ass.core.designsystem.theme.AssTheme

@Composable
fun SlimCheckBox(
    modifier: Modifier = Modifier,
    isChecked: Boolean = false,
    checkedColor: Color = AssTheme.colorScheme.avalancheDangerLevel3,
    uncheckedColor: Color = AssTheme.colorScheme.background,
    onValueChange: (Boolean) -> Unit,
    hasError: Boolean = false,
    enabled: Boolean = true,
) {
    val checkboxColor: Color by animateColorAsState(
        if (isChecked) checkedColor else uncheckedColor,
        label = stringResource(R.string.checkbox_color_change_animation)
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .wrapContentHeight()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .toggleable(
                    value = isChecked,
                    enabled = enabled,
                    role = Role.Checkbox,
                    onValueChange = onValueChange
                )
                .size(size = 24.dp)
                .background(
                    color = checkboxColor,
                    shape = RoundedCornerShape(size = 6.dp)
                )
                .border(
                    width = 2.dp,
                    color = when {
                        isChecked -> AssTheme.colorScheme.primary
                        hasError -> AssTheme.colorScheme.error
                        else -> AssTheme.colorScheme.secondary
                    },
                    shape = RoundedCornerShape(size = 6.dp)
                )
        ) {
            this@Row.AnimatedVisibility(
                visible = isChecked,
                enter = scaleIn(),
                exit = fadeOut()
            ) {
                Icon(
                    imageVector = AssIcons.AssCheckBox,
                    contentDescription = null,
                    tint = uncheckedColor
                )
            }
        }
        Text(
            text = stringResource(R.string.i_accept_this_disclaimer),
            style = AssTheme.typography.bodyLarge
        )
    }
}