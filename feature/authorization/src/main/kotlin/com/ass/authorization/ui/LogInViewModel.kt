package com.ass.authorization.ui

import androidx.lifecycle.viewModelScope
import com.ass.authorization.utils.isValidCheckBox
import com.ass.authorization.utils.isValidEmail
import com.ass.authorization.utils.isValidName
import com.ass.authorization.utils.isValidPhone
import com.ass.core.foundation.lifecycle.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class LogInViewModel() : BaseViewModel<LoginUiState>() {
    private val _uiState = MutableStateFlow(LoginUiState.empty)
    override val uiState: StateFlow<LoginUiState> = _uiState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = LoginUiState.empty
    )

    fun validateInput(fieldValue: String, inputType: InputType) {
        validateUiField(fieldValue, inputType)
        proceedLogin()
    }

    private fun validateUiField(field: String, inputType: InputType) {
        when (inputType) {
            InputType.EMAIL -> validateField(
                field, _uiState.value, ::isValidEmail, LoginUiState::email
            )

            InputType.NAME -> validateField(
                field, _uiState.value, ::isValidName, LoginUiState::name
            )

            InputType.SECOND_NAME -> validateField(
                field, _uiState.value, ::isValidName, LoginUiState::secondName
            )

            InputType.PHONE -> validateField(
                field, _uiState.value, ::isValidPhone, LoginUiState::phone
            )

            InputType.CHECKBOX -> validateField(
                field, _uiState.value, ::isValidCheckBox, LoginUiState::checkBox
            )
        }
    }

    private fun validateField(
        field: String,
        uiStateProvider: LoginUiState,
        validationFun: (String) -> Boolean,
        propertySelector: (LoginUiState) -> InputWrapper
    ) {
        val inputWrapper = propertySelector(uiStateProvider)
        val newWrapper = inputWrapper.copy(
            value = field,
            actionType = if (validationFun(field)) ActionType.NotifyWrongFormat else ActionType.Proceed,
            hasError = validationFun(field)
        )
        updateUiState(propertySelector, newWrapper)
    }

    private fun updateUiState(
        propertySelector: (LoginUiState) -> InputWrapper,
        newWrapper: InputWrapper
    ) {
        _uiState.update {
            when (propertySelector) {
                LoginUiState::email -> it.copy(email = newWrapper)
                LoginUiState::name -> it.copy(name = newWrapper)
                LoginUiState::secondName -> it.copy(secondName = newWrapper)
                LoginUiState::phone -> it.copy(phone = newWrapper)
                LoginUiState::checkBox -> it.copy(checkBox = newWrapper)
                else -> it
            }
        }
    }

    private fun proceedLogin() {
        if (checkConditions()) {
            _uiState.update { it.copy(proceed = true) }
        } else {
            _uiState.update { it.copy(proceed = false) }
        }
    }

    private fun checkConditions(): Boolean {
        return !_uiState.value.name.hasError && !_uiState.value.email.hasError &&
                !_uiState.value.phone.hasError && !_uiState.value.secondName.hasError &&
                _uiState.value.email.actionType == ActionType.Proceed &&
                _uiState.value.name.actionType == ActionType.Proceed &&
                _uiState.value.phone.actionType == ActionType.Proceed &&
                _uiState.value.secondName.actionType == ActionType.Proceed &&
                _uiState.value.checkBox.actionType == ActionType.Proceed
    }
}