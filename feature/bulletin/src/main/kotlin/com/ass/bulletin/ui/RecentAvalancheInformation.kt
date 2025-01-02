package com.ass.bulletin.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import com.ass.bulletin.domain.models.RecentAvalanche
import com.ass.core.designsystem.R
import com.ass.core.designsystem.theme.AssCornerRadius
import com.ass.core.designsystem.theme.AssElevation
import com.ass.core.designsystem.theme.AssHeights
import com.ass.core.designsystem.theme.AssPaddings
import com.ass.core.designsystem.theme.AssTheme

@Composable
fun RecentAvalancheInformation(
    recentAvalanche: RecentAvalanche,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(AssCornerRadius.cornerRadius16dp),
        colors = CardDefaults.cardColors(
            containerColor = AssTheme.colorScheme.background,
            contentColor = AssTheme.colorScheme.onSurface
        ),
        modifier = modifier.shadow(
            AssElevation.elevation2dp,
            RoundedCornerShape(AssCornerRadius.cornerRadius16dp)
        )
    ) {
        Spacer(modifier = Modifier.height(AssHeights.height8dp))
        Column(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(AssPaddings.padding16dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                Column(modifier = modifier.wrapContentHeight()) {
                    Text(
                        stringResource(R.string.date),
                        style = AssTheme.typography.labelSmall.copy(color = AssTheme.colorScheme.primary)
                    )
                    Spacer(modifier = Modifier.height(AssHeights.height8dp))
                    Text(
                        text = " ${recentAvalanche.date}",
                        style = AssTheme.typography.bodyMedium.copy(color = AssTheme.colorScheme.primary)
                    )
                    Spacer(modifier = Modifier.height(AssHeights.height16dp))
                    Text(
                        stringResource(R.string.elevation),
                        style = AssTheme.typography.labelSmall.copy(color = AssTheme.colorScheme.primary)
                    )
                    Spacer(modifier = Modifier.height(AssHeights.height8dp))
                    Text(
                        text = " ${recentAvalanche.elevation}",
                        style = AssTheme.typography.bodyMedium.copy(color = AssTheme.colorScheme.primary)
                    )
                }
                Column {
                    Text(
                        stringResource(R.string.size),
                        style = AssTheme.typography.labelSmall.copy(color = AssTheme.colorScheme.primary)
                    )
                    Spacer(modifier = Modifier.height(AssPaddings.padding8dp))
                    Text(
                        text = " ${recentAvalanche.size}",
                        style = AssTheme.typography.labelMedium.copy(color = AssTheme.colorScheme.primary)
                    )
                    Spacer(modifier = Modifier.height(AssPaddings.padding16dp))
                    Text(
                        stringResource(R.string.triggered_by),
                        style = AssTheme.typography.labelSmall.copy(color = AssTheme.colorScheme.primary)
                    )
                    Spacer(modifier = Modifier.height(AssPaddings.padding8dp))
                    Text(
                        text = " ${recentAvalanche.triggeredBy}",
                        style = AssTheme.typography.labelMedium.copy(color = AssTheme.colorScheme.primary)
                    )
                }
                Column {
                    Text(
                        stringResource(R.string.aspect),
                        style = AssTheme.typography.labelSmall.copy(color = AssTheme.colorScheme.primary)
                    )
                    Spacer(modifier = Modifier.height(AssPaddings.padding8dp))
                    Text(
                        text = " ${recentAvalanche.aspect}",
                        style = AssTheme.typography.bodyMedium.copy(color = AssTheme.colorScheme.primary)
                    )
                    Spacer(modifier = Modifier.height(AssHeights.height16dp))
                    Text(
                        stringResource(R.string.type),
                        style = AssTheme.typography.labelSmall.copy(color = AssTheme.colorScheme.primary)
                    )
                    Spacer(modifier = Modifier.height(AssHeights.height8dp))
                    Text(
                        text = " ${recentAvalanche.type}",
                        style = AssTheme.typography.bodyMedium.copy(color = AssTheme.colorScheme.primary)
                    )
                }
            }
            Spacer(modifier = Modifier.height(AssHeights.height16dp))
            Text(
                text = recentAvalanche.description,
                style = AssTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}