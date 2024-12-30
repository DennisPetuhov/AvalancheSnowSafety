package com.ass.bulletin.ui.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ass.bulletin.domain.models.HazardRatings
import com.ass.bulletin.domain.models.RecentAvalanche
import com.ass.bulletin.ui.BulletinUiState
import com.ass.bulletin.ui.RecentAvalancheInformation
import com.ass.core.designsystem.R
import com.ass.core.designsystem.components.icons.AssIcons
import com.ass.core.designsystem.theme.AssPaddings
import com.ass.core.designsystem.theme.AssTheme

@Composable
fun BulletinDoubleColumnText(
    upperText: String,
    bottomText: String,
    upperTextStyle: TextStyle = AssTheme.typography.labelSmall.copy(fontWeight = FontWeight.Companion.SemiBold),
    bottomTextStyle: TextStyle = AssTheme.typography.labelSmall,
    modifier: Modifier = Modifier.Companion
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Companion.CenterHorizontally,
        modifier = modifier.wrapContentSize()
    ) {
        Text(upperText, style = upperTextStyle)
        Spacer(modifier = modifier.padding(2.dp))
        Text(bottomText, style = bottomTextStyle)
    }
}

@Composable
fun RecentAvalanchesInformation(uiState: BulletinUiState) {
    val resentAvalanches: List<RecentAvalanche> = uiState.recentAvalanches
    for (avalanche in resentAvalanches) {
        Spacer(modifier = Modifier.height(AssPaddings.padding8dp))
        RecentAvalancheInformation(recentAvalanche = avalanche)
    }
}

@Composable
fun RecentSnowPackInformation(uiState: BulletinUiState, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(AssPaddings.padding16dp)

    ) {
        Text(
            text = uiState.snowPack, style = AssTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface

        )
    }
}

@Composable
fun RecentWeatherInformation(uiState: BulletinUiState, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(AssPaddings.padding16dp)

    ) {
        Text(
            text = uiState.weather, style = AssTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun setTheAvalancheDangerLevelIcon(dangerLevel: HazardRatings): ImageVector {
    return when (dangerLevel.overAll) {
        "4" -> AssIcons.AvalancheDangerDryLevelFourFive
        "3" -> AssIcons.AvalancheDangerDryLevelThree
        "2" -> AssIcons.AvalancheDangerDryLevelTwo
        "1" -> AssIcons.AvalancheDangerDryLevelOne
        "0" -> AssIcons.AvalancheDangerDryLevelZero
        else -> AssIcons.AvalancheDangerDryLevelFourFive
    }
}

@Composable
fun setTheAvalancheDangerLevelDescription(dangerLevel: HazardRatings): String {
    return when (dangerLevel.overAll) {
        "4" -> stringResource(R.string.main_text_hazard_rating_4)
        "3" -> stringResource(R.string.main_text_hazard_rating_3)
        "2" -> stringResource(R.string.main_text_hazard_rating_2)
        "1" -> stringResource(R.string.main_text_hazard_rating_1)
        "0" -> stringResource(R.string.main_text_hazard_rating_0)
        else -> stringResource(R.string.main_text_hazard_rating_0)
    }
}

@Composable
fun setAvalancheDangerColor(dangerLevel: HazardRatings): Color {
    return when (dangerLevel.overAll) {
        "4" -> AssTheme.colorScheme.avalancheDangerLevel4
        "3" -> AssTheme.colorScheme.avalancheDangerLevel3
        "2" -> AssTheme.colorScheme.avalancheDangerLevel2
        "1" -> AssTheme.colorScheme.avalancheDangerLevel1
        "0" -> AssTheme.colorScheme.outlineVariant
        else -> AssTheme.colorScheme.avalancheDangerLevel4
    }
}