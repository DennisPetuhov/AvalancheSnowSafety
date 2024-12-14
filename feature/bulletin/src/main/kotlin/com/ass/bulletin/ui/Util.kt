package com.ass.bulletin.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ass.core.designsystem.theme.AssTheme


@Composable
fun BulletinDoubleColumnText(
    upperText: String,
    bottomText: String,
    upperTextStyle: TextStyle = AssTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold),
    bottomTextStyle: TextStyle = AssTheme.typography.labelSmall,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.wrapContentSize()
    ) {
        Text(upperText, style = upperTextStyle)
        Spacer(modifier = modifier.padding(2.dp))
        Text(bottomText, style = bottomTextStyle)
    }

}