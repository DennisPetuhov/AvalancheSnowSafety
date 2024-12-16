package com.ass.core.designsystem.components.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.ass.core.designsystem.R


object AssIcons {
    val ArrowBack: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_arrow_back)
    val bulletin: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_bulletin_filled)
    val bulletinOutlined: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_bulletin_outlined)
    val knowledge: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_knowledge_filled)
    val knowledgeOutlined: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_knowledge_outlined)
    val weather: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_weather_filled)
    val weatherOutlined: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_weather_outlined)
    val avalancheOutlinedFab: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_landslide_outlined)
    val weatherOutlinedFab: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_weather_snowy_outlined)
    val SnowPackConditionsOutlinedFab: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_snowpack_conditions_outlined)
    val AvalancheDangerDryLevelZero: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_avalanche_danger_level_no)
    val AvalancheDangerDryLevelOne: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_avalanche_danger_level_dry_snow_1)
    val AvalancheDangerDryLevelTwo: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_avalanche_danger_level_dry_snow_2)
    val AvalancheDangerDryLevelThree: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_avalanche_danger_level_dry_snow_3)
    val AvalancheDangerDryLevelFourFive: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_avalanche_danger_level_dry_snow_4_5)
    val AvalancheProblemGlidingSnow: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_avalanche_problem_gliding_snow_grey)
    val AvalancheProblemNewSnow: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_avalanche_problem_new_snow_grey)
    val MoreAboutAvalanche: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_more_about_avalanche)
    val AssLogoSplash: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_zvavi_logo_large)
    val AssLogo: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_zvavi_logo_small)
    val AssCheckBox: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_checkbox)
}