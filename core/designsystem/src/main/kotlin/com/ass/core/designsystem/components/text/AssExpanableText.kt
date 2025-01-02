package com.ass.core.designsystem.components.text

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import com.ass.core.designsystem.R
import com.ass.core.designsystem.theme.AssAngle
import com.ass.core.designsystem.theme.AssCornerRadius
import com.ass.core.designsystem.theme.AssElevation
import com.ass.core.designsystem.theme.AssPaddings
import com.ass.core.designsystem.theme.AssTheme
import com.ass.core.foundation.lifecycle.BaseUiState


@Composable
fun AssExpandableText(
    fieldName: String,
    uiState: BaseUiState,
    isExpanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    recentInformation: @Composable (BaseUiState) -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val rotationAngle = animateFloatAsState(
        targetValue = if (isExpanded) AssAngle.angle180 else AssAngle.angle0,
        label = ""
    )

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .shadow(AssElevation.elevation2dp, RoundedCornerShape(AssCornerRadius.cornerRadius16dp))
            .background(
                AssTheme.colorScheme.background,
                RoundedCornerShape(AssCornerRadius.cornerRadius16dp)
            )
            .clickable(interactionSource, null) { onExpandedChange(!isExpanded) }
            .padding(top = AssPaddings.padding8dp)
            .wrapContentHeight()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(horizontal = AssPaddings.padding16dp)
        ) {
            Text(
                text = fieldName,
                style = AssTheme.typography.titleSmall,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = if (isExpanded) stringResource(R.string.collapse) else stringResource(
                    R.string.expand
                ),
                tint = AssTheme.colorScheme.primary,
                modifier = Modifier.graphicsLayer(rotationZ = rotationAngle.value)
            )
        }
        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) { recentInformation(uiState) }
        }
    }
}
