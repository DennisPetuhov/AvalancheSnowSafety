package com.ass.authorization.ui.screens.login

import com.ass.core.foundation.lifecycle.BaseUiState


data class LoginUiState(
    val email: InputWrapper,
    val name: InputWrapper,
    val secondName: InputWrapper,
    val phone: InputWrapper,
    val proceed: Boolean,
    val checkBox: InputWrapper,
):BaseUiState {
    companion object {
        val empty = LoginUiState(
            email = InputWrapper("", ActionType.None, false),
            name = InputWrapper("", ActionType.None, false),
            secondName = InputWrapper("", ActionType.None, false),
            phone = InputWrapper("", ActionType.None, false),
            proceed = false,
            checkBox = InputWrapper("", ActionType.None, false)
        )
    }
}

data class InputWrapper(
    val value: String,
    val actionType: ActionType,
    val hasError: Boolean,
)