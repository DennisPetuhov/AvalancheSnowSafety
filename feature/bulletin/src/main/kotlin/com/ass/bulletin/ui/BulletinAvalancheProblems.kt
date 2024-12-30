package com.ass.bulletin.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.ass.bulletin.domain.models.AvalancheProblem
import com.ass.bulletin.ui.screens.AvalancheProblemIconAndType
import com.ass.bulletin.ui.util.RecentAvalanchesInformation
import com.ass.bulletin.ui.util.RecentSnowPackInformation
import com.ass.bulletin.ui.util.RecentWeatherInformation
import com.ass.core.designsystem.R
import com.ass.core.designsystem.components.text.AssExpandableText
import com.ass.core.designsystem.components.icons.AssIcons
import com.ass.core.designsystem.theme.AssPaddings
import com.ass.core.designsystem.theme.AssTheme

@Composable
fun AvalancheProblems(uiState: BulletinUiState, modifier: Modifier) {
    var expandedStateAvalanche by remember { mutableStateOf(false) }
    var expandedStateSnowPack by remember { mutableStateOf(false) }
    var expandedStateWeather by remember { mutableStateOf(false) }

    Column {
        Text(
            text = stringResource(R.string.avalanche_problems),
            style = AssTheme.typography.titleMedium,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = modifier.padding(AssPaddings.padding10dp))
        SetAvalancheProblemIcons(uiState.avalancheProblems, modifier)
        Spacer(modifier = modifier.padding(AssPaddings.padding12dp))
        AssExpandableText(
            fieldName = stringResource(com.ass.core.feature.bulletin.R.string.recent_avalanches),
            uiState = uiState,
            isExpanded = expandedStateAvalanche,
            onExpandedChange = { expandedStateAvalanche = it },
            recentInformation = { RecentAvalanchesInformation(it as BulletinUiState) },
            modifier = modifier
        )
        Spacer(modifier = modifier.padding(AssPaddings.padding1dp))
        AssExpandableText(
            fieldName = stringResource(com.ass.core.feature.bulletin.R.string.snowpack),
            uiState = uiState,
            isExpanded = expandedStateSnowPack,
            onExpandedChange = { expandedStateSnowPack = it },
            recentInformation = { RecentSnowPackInformation(it as BulletinUiState) },
            modifier = modifier
        )
        Spacer(modifier = modifier.padding(AssPaddings.padding1dp))
        AssExpandableText(
            fieldName = stringResource(com.ass.core.feature.bulletin.R.string.weather),
            uiState = uiState,
            isExpanded = expandedStateWeather,
            onExpandedChange = { expandedStateWeather = it },
            recentInformation = { RecentWeatherInformation(it as BulletinUiState) },
            modifier = modifier
        )
    }
}

@Composable
private fun SetAvalancheProblemIcons(problems: List<AvalancheProblem>, modifier: Modifier) {
    Row(horizontalArrangement = Arrangement.Center, modifier = modifier.fillMaxWidth()) {
        problems.forEach { problem ->
            AvalancheProblemIconAndType(
                avalancheProblemImage = setIconDependingOnProblemType(problem),
                avalancheProblemType = problem.kind,
                modifier = modifier
            )
            Spacer(modifier = modifier.padding(AssPaddings.padding10dp))
        }
    }
}

@Composable
fun setIconDependingOnProblemType(avalancheProblem: AvalancheProblem): ImageVector {
    return when (avalancheProblem.kind) {
        "Gliding Snow", "Glide Avalanche" -> AssIcons.AvalancheProblemGlidingSnow
        "Storm Slab" -> AssIcons.AvalancheProblemNewSnow
        "Wind Slab" -> AssIcons.AvalancheProblemWindSlab
        "Persistent Slab", "Deep Slab" -> AssIcons.AvalancheProblemPersistentWeakLayer
        "Loose Wet", "Wet Slab", "Loose Dry" -> AssIcons.AvalancheProblemWetSnow
        else -> AssIcons.AvalancheProblemNewSnow
    }
}