package com.ass.core.designsystem.components.fab

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.ass.core.designsystem.theme.AssTheme


/**
 * Represents a sub-item for a Floating Action Button (FAB) with customized icon and background tints.
 * Sub-items are secondary action buttons that appear when the main FAB is expanded.
 */
interface FabButtonSub {
    val iconTint: Color
    val backgroundTint: Color
}

/**
 * Implementation of [FabButtonSub] interface.
 *
 * @property iconTint The [Color] used to tint the icon of the sub-item.
 * @property backgroundTint The [Color] used to tint the background of the sub-item.
 */
private class FabButtonSubImpl(
    override val iconTint: Color,
    override val backgroundTint: Color
) : FabButtonSub

/**
 * Creates a new instance of [FabButtonSub] with the provided icon and background tints.
 *
 * @param backgroundTint The [Color] used to tint the background of the sub-item.
 * @param iconTint The [Color] used to tint the icon of the sub-item.
 * @return A new instance of [FabButtonSub] with the specified icon and background tints.
 */
@Composable
fun fabButtonSub(
    backgroundTint: Color = AssTheme.colorScheme.tertiary,
    iconTint: Color = AssTheme.colorScheme.background
): FabButtonSub = FabButtonSubImpl(iconTint, backgroundTint)