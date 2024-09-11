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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import com.ass.core.designsystem.R

@Composable
fun SlimCheckBox(
    modifier: Modifier = Modifier,
    isChecked: Boolean = false,
    checkedColor: Color = Color.Blue,
    uncheckedColor: Color = Color.Cyan,
    onValueChange: (Boolean) -> Unit,
    checkBoxLabel: AnnotatedString = buildAnnotatedString {},
    hasError: Boolean = false,
    enabled: Boolean = true,
) {
    val checkboxColor: Color by animateColorAsState(
        if (isChecked) checkedColor else uncheckedColor,
        label = stringResource(R.string.checkbox_color_change_animation)
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .toggleable(
                    value = isChecked,
                    enabled = enabled,
                    role = Role.Checkbox,
                    onValueChange = onValueChange
                )
                .size(size = 20.dp)
                .background(
                    color = checkboxColor,
                    shape = RoundedCornerShape(size = 6.dp)
                )
                .border(
                    width = 2.dp,
                    color = when {
                        isChecked -> Color.Green
                        hasError -> Color.Red
                        else -> Color.Blue
                    },
                    shape = RoundedCornerShape(size = 6.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            this@Row.AnimatedVisibility(
                visible = isChecked,
                enter = scaleIn(),
                exit = fadeOut()
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.icon_checkbox),
                    contentDescription = null,
                    tint = uncheckedColor
                )
            }
        }
        ClickableText(
            text = checkBoxLabel,
            modifier = Modifier.padding(start = 6.dp),
//            style = AssTheme.typography.bodySmall,
            onClick = {}
        )
    }
}