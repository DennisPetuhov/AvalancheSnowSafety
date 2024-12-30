package com.ass.bulletin.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.ass.bulletin.domain.models.HazardRatings
import com.ass.bulletin.ui.util.setTheAvalancheDangerLevelIcon
import com.ass.core.designsystem.theme.*
import com.ass.core.designsystem.R


@Composable
fun BulletinCommonDanger(
    dangerLevel: HazardRatings = HazardRatings(overAll = "2", highAlpine = "1", alpine = "3", subAlpine = "0"),
    setTheAvalancheDangerLevelDescription: @Composable (dangerLevel: HazardRatings) -> String,
    setAvalancheDangerColor: @Composable (dangerLevel: HazardRatings) -> Color,
    additionalForecastInfo: String = "New snow will begin later on Sunday. A high freezing level means loose wet avalanches and glide slabs are possible in the sub-alpine. Take care at high elevations where the snowpack is rocky, shallow and steep, as the recent cold snap could have promoted facet (weak layer) formation there.",
    modifier: Modifier = Modifier
) {
    Card(
        border = BorderStroke(AssBorder.width4dp, setAvalancheDangerColor(dangerLevel)),
        shape = CardDefaults.outlinedShape,
        colors = CardDefaults.cardColors(
            contentColor = AssTheme.colorScheme.onSurface,
            containerColor = AssTheme.colorScheme.background,
            disabledContentColor = AssTheme.colorScheme.primary,
            disabledContainerColor = AssTheme.colorScheme.tertiary
        ),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .shadow(
                elevation = AssElevation.elevation8dp,
                shape = RoundedCornerShape(AssCornerRadius.cornerRadius16dp),
                ambientColor = AssTheme.colorScheme.secondary,
                spotColor = AssTheme.colorScheme.primary
            )
    ) {
        Column(modifier = modifier.padding(AssPaddings.padding16dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    imageVector = setTheAvalancheDangerLevelIcon(dangerLevel),
                    contentDescription = stringResource(R.string.danger_level),
                    alignment = Alignment.Center,
                    modifier = Modifier.size(AssSize.size80dp)
                )
                Spacer(modifier = Modifier.width(AssPaddings.padding4dp))
                Text(
                    text = setTheAvalancheDangerLevelDescription(dangerLevel),
                    style = AssTheme.typography.bodyMedium
                )
            }
            HorizontalDivider(
                color = setAvalancheDangerColor(dangerLevel),
                modifier = Modifier.padding(vertical = AssPaddings.padding8dp)
            )
            Text(
                text = additionalForecastInfo,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}