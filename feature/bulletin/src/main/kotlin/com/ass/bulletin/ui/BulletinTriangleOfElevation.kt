package com.ass.bulletin.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ass.core.designsystem.theme.AssTheme
import com.ass.core.designsystem.R

@Composable
fun BulletinTriangleOfElevation(
    upperTriangleDangerLevel: String,
    mediumTriangleDangerLevel: String,
    bottomTriangleDangerLevel: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .fillMaxWidth()
            .wrapContentHeight()) {
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
                ElevationLevel(R.string.high_alpine_2600m, modifier)
                Spacer(modifier.height(16.dp))
                ElevationLevel(R.string.alpine_2000m_2600m, modifier)
                Spacer(modifier.height(8.dp))
                ElevationLevel(R.string.sub_alpine_2000m, modifier)
            }

            TriangleOfElevation(
                onIconClick = { },
                triangleUpperText = upperTriangleDangerLevel,
                triangleMediumText = mediumTriangleDangerLevel,
                triangleBottomText = bottomTriangleDangerLevel,
                modifier = modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ElevationLevel(elevation: Int, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .size(width = 160.dp, height = 32.dp)
            .shadow(
                spotColor = AssTheme.colorScheme.primary,
                ambientColor = AssTheme.colorScheme.secondary,
                elevation = 4.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(16.dp),
            )
            .border(
                BorderStroke(1.dp, AssTheme.colorScheme.secondary),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            stringResource(elevation),
            style = AssTheme.typography.bodySmall,
            minLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}