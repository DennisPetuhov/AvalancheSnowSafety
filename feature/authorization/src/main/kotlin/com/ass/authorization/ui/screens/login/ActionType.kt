package com.ass.authorization.ui.screens.login

sealed class ActionType {
    data object NotifyWrongFormat : ActionType()
    data object Proceed : ActionType()
    data object None : ActionType()
}

enum class InputType {
    EMAIL, NAME, SECOND_NAME, CHECKBOX, PHONE
}