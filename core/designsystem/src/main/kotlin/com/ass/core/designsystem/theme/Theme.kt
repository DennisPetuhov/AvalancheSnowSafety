package com.ass.core.designsystem.theme

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.core.view.WindowCompat
import androidx.compose.ui.graphics.Color as AssColor

private val DarkColorScheme = darkColorScheme(
    primary = AccentBlue,
    secondary = BrightBlue,
    tertiary = GreyBlue,
    outline = Grey,
    outlineVariant = Black,
    background = White,
    error = Red,
    errorContainer = LightRed
)

private val LightColorScheme = lightColorScheme(
    primary = AccentBlue,
    secondary = BrightBlue,
    tertiary = GreyBlue,
    outline = Grey,
    outlineVariant = Black,
    background = White,
    error = Red,
    errorContainer = LightRed

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun AvalancheSnowSafetyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.TRANSPARENT
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Immutable
data class AssColors(
    val primary: AssColor,
    val secondary: AssColor,
    val tertiary: AssColor,
    val outline: AssColor,
    val outlineVariant: AssColor,
    val background: AssColor,
    val error: AssColor,
    val errorContainer: AssColor,
    val transparent:AssColor
)

@Immutable
data class AssTypography(
    val bodyLarge: TextStyle,
)

val LocalMiBankTypography =
    staticCompositionLocalOf { AssTypography(bodyLarge = Typography.bodyLarge) }

val LocalAssColors = staticCompositionLocalOf {
    AssColors(
        primary = LightColorScheme.primary,
        secondary = LightColorScheme.secondary,
        tertiary = LightColorScheme.tertiary,
        outline = LightColorScheme.outline,
        outlineVariant = LightColorScheme.outlineVariant,
        background = LightColorScheme.background,
        error = LightColorScheme.error,
        errorContainer = LightColorScheme.errorContainer,
        transparent = androidx.compose.ui.graphics.Color.Transparent
    )
}

object AssTheme {
    val typography: AssTypography
        @Composable
        get() = LocalMiBankTypography.current
    val colorScheme: AssColors
        @Composable
        get() = LocalAssColors.current
}