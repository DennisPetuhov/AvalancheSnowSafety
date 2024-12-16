package com.ass.core.designsystem.theme

import android.os.Build
import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ass.core.designsystem.R

@OptIn(ExperimentalTextApi::class)
val RobotoFlex =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        FontFamily(
            Font(
                R.font.roboto_flex,
                variationSettings = FontVariation.Settings(
                    FontVariation.weight(AssFontConfig.WEIGHT),
                    FontVariation.width(AssFontConfig.WIDTH),
                    FontVariation.slant(AssFontConfig.SLANT),
                )
            )
        )
    } else {
        FontFamily.Default
    }

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = RobotoFlex,
        fontWeight = FontWeight.Normal,
        fontSize = AssFontSizes.fontSize57sp,
        lineHeight = AssLinedHeights.lineHeight64,
        letterSpacing = AssLetterSpacings.byMinus025sp

    ), displayMedium = TextStyle(
        fontFamily = RobotoFlex,
        fontWeight = FontWeight.Normal,
        fontSize = AssFontSizes.fontSize52sp,
        lineHeight = AssLinedHeights.lineHeight45,
        letterSpacing = AssLetterSpacings.by0sp

    ), displaySmall = TextStyle(
        fontFamily = RobotoFlex,
        fontWeight = FontWeight.Normal,
        fontSize = AssFontSizes.fontSize36sp,
        lineHeight = AssLinedHeights.lineHeight44,
        letterSpacing = AssLetterSpacings.by0sp
    ),

    headlineLarge = TextStyle(
        fontFamily = RobotoFlex,
    ),

    headlineMedium = TextStyle(
        fontFamily = RobotoFlex,
    ),

    headlineSmall = TextStyle(
        fontFamily = RobotoFlex,
        fontWeight = FontWeight.Medium,
    ),

    bodyLarge = TextStyle(
        fontFamily = RobotoFlex,
        fontWeight = FontWeight.ExtraBold,
        fontSize = AssFontSizes.fontSize16sp,
        lineHeight = AssLinedHeights.lineHeight24,
        letterSpacing = AssLetterSpacings.by05sp
    ),
    bodyMedium = TextStyle(
        fontFamily = RobotoFlex,
        fontWeight = FontWeight.Bold,
        fontSize = AssFontSizes.fontSize14sp,
        lineHeight = AssLinedHeights.lineHeight20,
        letterSpacing = AssLetterSpacings.by02sp
    ),
    bodySmall = TextStyle(
        fontFamily = RobotoFlex,
        fontWeight = FontWeight.Normal,
        letterSpacing = AssLetterSpacings.by05sp,
        lineHeight = AssLinedHeights.lineHeight16
    ),
    titleLarge = TextStyle(
        fontFamily = RobotoFlex,
        fontWeight = FontWeight.Normal,
        fontSize = AssFontSizes.fontSize22sp,
        lineHeight = 28.sp,
        letterSpacing = AssLetterSpacings.by0sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = AssFontSizes.fontSize20sp,
        letterSpacing = AssLetterSpacings.by01sp,
        lineHeight = AssLinedHeights.lineHeight20
    ),
    titleSmall = TextStyle(
        fontFamily = RobotoFlex,
        fontWeight = FontWeight.SemiBold,
        fontSize = AssFontSizes.fontSize14sp,
        lineHeight = AssLinedHeights.lineHeight16,
        letterSpacing = AssLetterSpacings.by05sp
    ),

    labelLarge = TextStyle(
        fontFamily = RobotoFlex,
        fontWeight = FontWeight.SemiBold,
        fontSize = AssFontSizes.fontSize14sp,
        lineHeight = AssLinedHeights.lineHeight20,
        letterSpacing = AssLetterSpacings.by01sp
    ),
    labelMedium = TextStyle(
        fontFamily = RobotoFlex,
        fontWeight = FontWeight.SemiBold,
        fontSize = AssFontSizes.fontSize12sp,
        lineHeight = AssLinedHeights.lineHeight16,
        letterSpacing = AssLetterSpacings.by05sp
    ),
    labelSmall = TextStyle(
        fontFamily = RobotoFlex,
        fontWeight = FontWeight.Normal,
        fontSize = AssFontSizes.fontSize11sp,
        lineHeight = AssLinedHeights.lineHeight16,
        letterSpacing = AssLetterSpacings.by05sp
    )
)