package com.ass.core.foundation.navigation

import androidx.navigation.NamedNavArgument
import com.ass.core.foundation.navigation.Routes.AUTHORIZATION_SCREEN
import com.ass.core.foundation.navigation.Routes.BULLETIN_SCREEN
import com.ass.core.foundation.navigation.Routes.KNOWLEDGE_SCREEN
import com.ass.core.foundation.navigation.Routes.OBSERVATION_MAIN_SCREEN
import com.ass.core.foundation.navigation.Routes.SPLASH_SCREEN
import com.ass.core.foundation.navigation.Routes.WEATHER_SCREEN
import com.ass.core.foundation.navigation.animation.AssNavAnimations
import com.ass.core.foundation.navigation.animation.FadeAnimations
import com.ass.core.foundation.navigation.animation.SlidingAnimations

object Routes {
    const val BULLETIN_SCREEN = "bulletin_screen"
    const val WEATHER_SCREEN = "weather_screen"
    const val KNOWLEDGE_SCREEN = "knowledge_screen"
    const val SPLASH_SCREEN = "splash_screen"
    const val AUTHORIZATION_SCREEN = "authorization_screen"
    const val OBSERVATION_MAIN_SCREEN = "observation_main_screen"
}

object SplashScreenDestination : AssNavDestinations, AssNavAnimations by SlidingAnimations {
    override val route: String = SPLASH_SCREEN
    override val arguments: List<NamedNavArgument> = emptyList()
}

object AuthorizationScreenDestination : AssNavDestinations, AssNavAnimations by SlidingAnimations {
    override val route: String = AUTHORIZATION_SCREEN
    override val arguments: List<NamedNavArgument> = emptyList()
}

object BulletinScreenDestination : AssNavDestinations, AssNavAnimations by FadeAnimations {
    override val route: String = BULLETIN_SCREEN
    override val arguments: List<NamedNavArgument> = emptyList()
}

object KnowledgeScreenDestination : AssNavDestinations, AssNavAnimations by FadeAnimations {
    override val route: String = KNOWLEDGE_SCREEN
    override val arguments: List<NamedNavArgument> = emptyList()
}

object WeatherScreenDestination : AssNavDestinations, AssNavAnimations by FadeAnimations {
    override val route: String = WEATHER_SCREEN
    override val arguments: List<NamedNavArgument> = emptyList()
}

object ObservationMainScreenDestination : AssNavDestinations, AssNavAnimations by FadeAnimations {
    override val route: String = OBSERVATION_MAIN_SCREEN
    override val arguments: List<NamedNavArgument> = emptyList()
}