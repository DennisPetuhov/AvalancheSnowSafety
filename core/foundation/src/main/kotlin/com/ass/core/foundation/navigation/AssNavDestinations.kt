package com.ass.core.foundation.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import com.ass.core.foundation.navigation.animation.AssNavAnimations

interface AssNavDestinations : AssNavAnimations {
    val route: String
    val arguments: List<NamedNavArgument>
    fun getDeepLinks(): List<NavDeepLink> = listOf()
}