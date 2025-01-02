package com.ass.bulletin.ui.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ass.bulletin.domain.models.HazardRatings
import com.ass.bulletin.ui.TriangleOfElevation
import com.ass.core.designsystem.R
import com.ass.core.designsystem.components.text.AssElevationLevel

@Composable
fun BulletinTriangleOfElevation(
    hazardRatings: HazardRatings,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .wrapContentHeight()
                    .weight(1f)
            ) {
                AssElevationLevel(R.string.high_alpine_2600m, modifier)
                Spacer(modifier.height(16.dp))
                AssElevationLevel(R.string.alpine_2000m_2600m, modifier)
                Spacer(modifier.height(8.dp))
                AssElevationLevel(R.string.sub_alpine_2000m, modifier)
            }
            TriangleOfElevation(
                onIconClick = { },
                hazardRatings = hazardRatings,
                modifier = modifier.weight(1f)
            )
        }
    }
}
