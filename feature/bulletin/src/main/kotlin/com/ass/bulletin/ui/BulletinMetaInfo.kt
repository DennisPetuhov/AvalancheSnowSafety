package com.ass.bulletin.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ass.core.designsystem.R
import com.ass.core.designsystem.theme.AssBorder
import com.ass.core.designsystem.theme.AssCornerRadius
import com.ass.core.designsystem.theme.AssElevation
import com.ass.core.designsystem.theme.AssPaddings
import com.ass.core.designsystem.theme.AssTheme

@Preview
@Composable
fun BulletinMetaInfo(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = AssElevation.elevation2dp,
                shape = RoundedCornerShape(AssCornerRadius.cornerRadius16dp),
                ambientColor = AssTheme.colorScheme.primary,
                spotColor = AssTheme.colorScheme.secondary
            )
            .background(
                color = AssTheme.colorScheme.background,
                shape = RoundedCornerShape(AssCornerRadius.cornerRadius16dp)
            )
            .padding(horizontal = AssPaddings.padding24dp, vertical = AssPaddings.padding2dp)
            .height(IntrinsicSize.Min)
    ) {
        BulletinDoubleColumnText(
            upperText = stringResource(R.string.forecast_issued_at),
            bottomText = "23 March 2024 01:00"
        )
        VerticalDivider(
            modifier = Modifier.fillMaxHeight(),
            thickness = AssBorder.width1dp,
            color = AssTheme.colorScheme.secondary
        )
        BulletinDoubleColumnText(
            upperText = stringResource(R.string.forecast_valid_until),
            bottomText = "24 March 2024 01:00"
        )
        Spacer(modifier = Modifier.padding(AssPaddings.padding2dp))
        VerticalDivider(
            modifier = Modifier.fillMaxHeight(),
            thickness = AssBorder.width1dp,
            color = AssTheme.colorScheme.secondary
        )
        BulletinDoubleColumnText(
            upperText = stringResource(R.string.forecaster),
            bottomText = "Manu Greer"
        )
    }
}