@file:OptIn(ExperimentalMaterial3Api::class)

package com.ass.core.designsystem.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ass.core.designsystem.theme.AssTheme
import com.ass.core.designsystem.theme.Borders
import com.ass.core.designsystem.theme.Paddings
import kotlinx.coroutines.delay

@Composable
fun MainTextField(
    inputFieldValue: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
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
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }
    LaunchedEffect(hideKeyboard) {
        if (hideKeyboard) {
            delay(1000)
            focusManager.clearFocus()
            onFocusClear()
        }
    }
    BasicTextField(
        keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
        maxLines = 1,
        enabled = enabled,
        singleLine = true,
        value = inputFieldValue,
        onValueChange = onValueChange,
        visualTransformation = visualTransformation,
        decorationBox = { innerTextField ->
            OutLinedForm(
                inputFieldValue = inputFieldValue,
                innerTextField = innerTextField,
                hasError = hasError,
                errorText = errorText,
                hint = hint,
                interactionSource = interactionSource,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                isBorderLess = isBorderLess
            )
        },
        modifier = modifier
            .background(Color.Green)
            .fillMaxWidth()
            .wrapContentHeight()
            .semantics { contentDescription = semanticContentDescription },
    )
}

@Composable
private fun OutLinedForm(
    isBorderLess: Boolean,
    inputFieldValue: TextFieldValue,
    hasError: Boolean,
    hint: String,
    errorText: String?,
    interactionSource: MutableInteractionSource,
    innerTextField: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    OutlinedTextFieldDefaults.DecorationBox(
        value = inputFieldValue.text,
        innerTextField = innerTextField,
        singleLine = true,
        enabled = true,
        placeholder = { Text(text = hint, color = AssTheme.colorScheme.primary) },
        visualTransformation = VisualTransformation.None,
        interactionSource = interactionSource,
        colors = getOutlinedTextFieldColors(isBorderLess, hasError),
        contentPadding = PaddingValues(
            start = Paddings.padding12dp,
            end = Paddings.padding12dp,
            top = Paddings.padding12dp,
            bottom = Paddings.padding12dp
        ),
        container = {
            OutlinedTextFieldDefaults.ContainerBox(
                enabled = true,
                isError = false,
                interactionSource = interactionSource,
                shape = RoundedCornerShape(40.dp),
                focusedBorderThickness = Borders.borderThickness2dp,
                unfocusedBorderThickness = Borders.borderThickness2dp,
                colors = getOutlinedTextFieldColors(isBorderLess, hasError)
            )
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        supportingText = {
            if (hasError) {
                Text(
                    modifier = Modifier.offset(x = 0.5.dp),
                    text = errorText ?: "",
                    color = Color.Red,
                )
            }
        }
    )
}

@Composable
private fun getOutlinedTextFieldColors(isBorderLess: Boolean, hasError: Boolean): TextFieldColors {
    return if (isBorderLess) {
        OutlinedTextFieldDefaults.colors(
            focusedBorderColor = AssTheme.colorScheme.transparent,
            unfocusedBorderColor = AssTheme.colorScheme.transparent
        )
    } else {
        OutlinedTextFieldDefaults.colors(
            focusedBorderColor = if (hasError) {
                AssTheme.colorScheme.error
            } else {
                AssTheme.colorScheme.outline
            },
            unfocusedBorderColor = if (hasError) {
                AssTheme.colorScheme.error
            } else {
                AssTheme.colorScheme.outline
            }
        )
    }
}