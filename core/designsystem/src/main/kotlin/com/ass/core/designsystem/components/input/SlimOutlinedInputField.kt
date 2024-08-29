package com.ass.core.designsystem.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SlimOutlinedInputField(
    modifier: Modifier = Modifier,
    inputFieldValue: TextFieldValue,
    inputFieldLabel: String = "",
    semanticContentDescription: String = "",
    onValueChange: (input: TextFieldValue) -> Unit,
    hint: String = "",
    errorText: String? = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable() (() -> Unit)? = null,
    hideKeyboard: Boolean = false,
    onFocusClear: () -> Unit = {},
    hasError: Boolean = false,
    enabled: Boolean = true,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(space = 0.5.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = inputFieldLabel,
//            style = "AssTheme.typography.labelLarge"
        )
        BasicTextField(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .padding(bottom = 6.dp)
                .wrapContentHeight()
                .semantics { contentDescription = semanticContentDescription },
            keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            maxLines = 1,
            enabled = enabled,
            singleLine = true,
            value = inputFieldValue,
            onValueChange = { newText -> onValueChange(newText) },
            visualTransformation = visualTransformation,
            decorationBox = { innerTextField ->
                OutlinedTextFieldDefaults.DecorationBox(
                    value = inputFieldValue.text,
                    innerTextField = innerTextField,
                    singleLine = true,
                    enabled = true,
                    placeholder = {
                        Text(
                            text = hint,
                            color = Color.Black,
//                            style = AssTheme.typography.bodyMedium
                        )
                    },
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interactionSource,
                    colors = OutlinedTextFieldDefaults.colors(),
                    contentPadding = PaddingValues(
                        start = 6.dp,
                        top = 6.dp,
                        end = 6.dp,
                        bottom = 6.dp
                    ),
                    container = {
                        OutlinedTextFieldDefaults.ContainerBox(
                            enabled = true,
                            isError = false,
                            interactionSource,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = if (hasError) {
                                    Color.Green
                                } else {
                                    Color.Magenta
                                },
                                unfocusedBorderColor = if (hasError) {
                                    Color.Red
                                } else {
                                    Color.Blue
                                }
                            ),
                            shape = RoundedCornerShape(size = 6.dp),
                            focusedBorderThickness = 2.dp,
                            unfocusedBorderThickness = 2.dp
                        )
                    },
                    trailingIcon = trailingIcon,
                    supportingText = {
                        Text(
                            modifier = Modifier.offset(x = 0.5.dp),
                            text = if (hasError) {
                                errorText ?: ""
                            } else {
                                ""
                            },
                            color = Color.Red,
//                            style = AssTheme.typography.small
                        )
                    }
                )
            }
        )
        if (hideKeyboard) {
            focusManager.clearFocus()
            onFocusClear()
        }
    }
}