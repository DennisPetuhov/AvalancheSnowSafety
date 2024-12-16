package com.ass.core.designsystem.components.input

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import com.ass.core.designsystem.theme.AssPaddings
import com.ass.core.designsystem.theme.AssSpacing
import com.ass.core.designsystem.theme.AssTheme

@Composable
fun SlimOutlinedInputField(
    inputFieldValue: TextFieldValue,
    onValueChange: (input: TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    inputFieldLabel: String = "",
    semanticContentDescription: String = "",
    hint: String = "",
    errorText: String? = "",
    isBorderLess: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    hideKeyboard: Boolean = false,
    hasError: Boolean = false,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text,
    onFocusClear: () -> Unit = {},
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(space = AssSpacing.spacedBy2dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = inputFieldLabel,
            style = AssTheme.typography.labelMedium,
            modifier = modifier.padding(start = AssPaddings.padding16dp)
        )
        MainTextField(
            inputFieldValue = inputFieldValue,
            onValueChange = onValueChange,
            enabled = enabled,
            hint = hint,
            errorText = errorText,
            visualTransformation = visualTransformation,
            hideKeyboard = hideKeyboard,
            hasError = hasError,
            imeAction = imeAction,
            keyboardType = keyboardType,
            onFocusClear = onFocusClear,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            semanticContentDescription = semanticContentDescription,
            isBorderLess = isBorderLess
        )
    }
}