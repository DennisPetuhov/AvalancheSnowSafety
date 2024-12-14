package com.ass.core.designsystem.components.snackBar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.ass.core.designsystem.R
import com.ass.core.designsystem.theme.AssTheme
import com.ass.core.designsystem.theme.AssCornerRadius
import com.ass.core.designsystem.theme.AssPaddings

@Composable
fun CustomSnackBar(
    modifier: Modifier = Modifier,
    icon: Painter = painterResource(id = R.drawable.icon_location_on_white),
    message: String = "",
    containerColor: Color = AssTheme.colorScheme.errorContainer,
    textColor: Color = AssTheme.colorScheme.error
) {
    val title: String? =
        if (message.contains(other = "\n")) message.substringBefore(delimiter = "\n") else null
    val description: String =
        if (message.contains(other = "\n")) message.substringAfter(delimiter = "\n") else message

    Snackbar(
        containerColor = containerColor,
        shape = RoundedCornerShape(size = AssCornerRadius.cornerRadius40dp),
        modifier = modifier.padding(AssPaddings.padding16dp),
        content = {
            Row(
                modifier = modifier.padding(
                    end = AssPaddings.padding10dp,
                    bottom = AssPaddings.padding10dp
                )
            ) {
                Icon(
                    modifier = modifier.padding(end = AssPaddings.padding10dp),
                    painter = icon,
                    contentDescription = stringResource(R.string.alert),
                    tint = textColor
                )
                Column(
                    modifier = Modifier
                ) {
                    title?.let { title ->
                        Text(
                            text = title,
                            style = AssTheme.typography.bodySmall,
                            color = textColor,
                            modifier = Modifier.padding(bottom = AssPaddings.padding10dp)
                        )
                    }
                    Text(
                        text = description,
                        style = AssTheme.typography.bodySmall,
                        color = textColor
                    )
                }
            }
        }
    )
}