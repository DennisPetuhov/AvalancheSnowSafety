package com.ass.bulletin.ui.util

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.ass.bulletin.ui.RecentAvalancheInformation
import com.ass.bulletin.ui.util.Recent.Avalanches
import com.ass.core.designsystem.components.icons.AssIcons
import com.ass.core.designsystem.theme.AssPaddings
import com.ass.core.designsystem.theme.AssTheme
import com.ass.network.models.assModels.Overall


@Composable
fun RecentAvalanchesInformation(item: Recent) {
    val avalanches = item as Avalanches
    val listOfAvalanches = avalanches.recentAvalanche
    for (avalanche in listOfAvalanches) {
        Spacer(modifier = Modifier.height(AssPaddings.padding8dp))
        RecentAvalancheInformation(recentAvalanche = avalanche)
    }
}

@Composable
fun RecentSnowPackInformation(item: Recent, modifier: Modifier = Modifier) {
    val newItem = item as Recent.SnowPack
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(AssPaddings.padding16dp)

    ) {
        Text(
            text = item.recentSnowPack, style = AssTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun RecentWeatherInformation(item: Recent, modifier: Modifier = Modifier) {
    val newItem = item as Recent.Weather
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(AssPaddings.padding16dp)

    ) {
        Text(
            text = newItem.recentWeather, style = AssTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}


sealed class Recent(val name: String) {
    data class Avalanches(val recentAvalanche: List<Avalanche>) :
        Recent(name = "RECENT AVALANCHES")

    data class SnowPack(val recentSnowPack: String) : Recent(name = "SNOWPACK")
    data class Weather(val recentWeather: String) : Recent(name = "WEATHER")
}

data class Avalanche(
    val data: String? = null,
    val size: String? = null,
    val aspect: List<String>? = null,
    var information: String? = null
)


val recentWeather = Recent.Weather(
    "The weather has been warm and sunny for the past few days, with temperatures " +
            "reaching 10 degrees at 2000m. The freezing level has been around 3000m. " +
            "The forecast is for continued warm weather with a chance of rain on Thursday."
)
val recentSnowPack =
    Recent.SnowPack(
        "Around 80 cm of new snow fell between Thursday night and Monday. The new layer is" +
                " becoming more stable due to mild temperatures, but the previous snowpack has crusts " +
                "with and weak facet layers in the upper half. Whumphing and failures in snow tests have been " +
                "seen recently. Wind yesterday from SW and W will have formed slabs near ridges in sheltered areas." +
                " Cornices in some locations are getting large (particularly on Lomisa Ridge); treat them with respect.",
    )

val recentAvalanches = Avalanches(
    listOf(
        Avalanche(
            data = "25 March",
            size = "3",
            aspect = listOf("N"),
            information = "Multiple size 3 slabs, N aspect along the ridge E of Arakhveti on or near Mujukhi."
        ),
        Avalanche(
            data = "20 March",
            size = "3",
            aspect = listOf("S", "SW", "NE"),
            information = "Natural size 3 storm slab, S side of Sadzele 3200 m, and another nearby size 3 avalanche on SW side of Konstitucion (Black Ridge) at 3100m. Both of these were likely triggered by smaller loose wet slides from above. Several recent natural slab avalanches on Lomisa Ridge (NE aspect). A report of a probable size 2 skier triggered slide on a shady aspect in Kobe valley. Multiple small loose wet slides on S aspects."
        ),
        Avalanche(
            data = "21 March",
            size = "3",
            aspect = listOf("SW", "W", "SE"),
            information = "Natural size 3 storm slab, SW aspect, in Kobe Valley next to the waterfall, likely triggered by loose wet avalanche. Several size 1 to 2 slab avalanches on W and SE aspects with some evidence of step-down between layers."
        )
    )
)



@Composable
fun setTheAvalancheDangerLevelIcon(dangerLevel: Overall): ImageVector {
    return when (dangerLevel.value) {
        "4" -> AssIcons.AvalancheDangerDryLevelFourFive
        "3" -> AssIcons.AvalancheDangerDryLevelThree
        "2" -> AssIcons.AvalancheDangerDryLevelTwo
        "1" -> AssIcons.AvalancheDangerDryLevelOne
        "0" -> AssIcons.AvalancheDangerDryLevelZero
        else -> AssIcons.AvalancheDangerDryLevelFourFive
    }
}

val mainDescriptionString =
    "Natural avalanches are unlikely, human-triggered avalanches are possible. Small avalanches in specific areas, or large avalanches in isolated areas."

@Composable
fun setTheAvalancheDangerLevelDescription(dangerLevel: Overall): String {
    return when (dangerLevel.value) {
        "4" -> mainDescriptionString
        "3" -> mainDescriptionString
        "2" -> mainDescriptionString
        "1" -> mainDescriptionString
        "0" -> mainDescriptionString
        else -> mainDescriptionString
    }
}

@Composable
fun setAvalancheDangerColor(dangerLevel: Overall): Color {
    return when (dangerLevel.value) {
        "4" -> AssTheme.colorScheme.avalancheDangerLevel4
        "3" -> AssTheme.colorScheme.avalancheDangerLevel3
        "2" -> AssTheme.colorScheme.avalancheDangerLevel2
        "1" -> AssTheme.colorScheme.avalancheDangerLevel1
        "0" -> AssTheme.colorScheme.outlineVariant
        else -> AssTheme.colorScheme.avalancheDangerLevel4
    }
}