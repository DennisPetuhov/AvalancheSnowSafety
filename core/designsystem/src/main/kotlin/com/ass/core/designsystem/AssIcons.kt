package com.ass.core.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource


object AssIcons {
    val arrowBack: ImageVector
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
    val snowPackConditionsOutlinedFab: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.icon_snowpack_conditions_outlined)
}