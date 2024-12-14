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
import androidx.compose.ui.res.stringResource
import com.ass.bulletin.ui.util.RecentAvalanchesInformation
import com.ass.bulletin.ui.util.RecentSnowPackInformation
import com.ass.bulletin.ui.util.RecentWeatherInformation
import com.ass.bulletin.ui.util.recentAvalanches
import com.ass.bulletin.ui.util.recentSnowPack
import com.ass.bulletin.ui.util.recentWeather
import com.ass.core.designsystem.components.icons.AssIcons
import com.ass.core.designsystem.theme.AssPaddings
import com.ass.core.designsystem.theme.AssTheme
import com.ass.core.designsystem.R


@Composable
fun AvalancheProblems(modifier: Modifier) {
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
        Row(horizontalArrangement = Arrangement.Center, modifier = modifier.fillMaxWidth()) {
            AvalancheProblemIconAndType(
                avalancheProblemImage = AssIcons.AvalancheProblemGlidingSnow,
                avalancheProblemType = "Gliding Snow",
                modifier = modifier
            )
            Spacer(modifier = modifier.padding(AssPaddings.padding10dp))
            AvalancheProblemIconAndType(
                avalancheProblemImage = AssIcons.AvalancheProblemGlidingSnow,
                avalancheProblemType = "Glide Snow",
                modifier = modifier
            )
            Spacer(modifier = modifier.padding(AssPaddings.padding10dp))
            AvalancheProblemIconAndType(
                avalancheProblemImage = AssIcons.AvalancheProblemNewSnow,
                avalancheProblemType = "Wet Snow",
                modifier = modifier
            )
        }
        Spacer(modifier = modifier.padding(AssPaddings.padding12dp))
        AssExpandableText(
            item = recentAvalanches,
            isExpanded = expandedStateAvalanche,
            onExpandedChange = { expandedStateAvalanche = it },
            recentInformation = { RecentAvalanchesInformation(it) },
            modifier = modifier
        )
        Spacer(modifier = modifier.padding(AssPaddings.padding1dp))
        AssExpandableText(
            item = recentSnowPack,
            isExpanded = expandedStateSnowPack,
            onExpandedChange = { expandedStateSnowPack = it },
            recentInformation = { RecentSnowPackInformation(it) },
            modifier = modifier
        )
        Spacer(modifier = modifier.padding(AssPaddings.padding1dp))
        AssExpandableText(
            item = recentWeather,
            isExpanded = expandedStateWeather,
            onExpandedChange = { expandedStateWeather = it },
            recentInformation = { RecentWeatherInformation(it) },
            modifier = modifier
        )
    }
}