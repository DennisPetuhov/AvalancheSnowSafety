package com.ass.authorization.ui


data class LoginUiState(
    val email: InputWrapper,
    val name: InputWrapper,
    val secondName: InputWrapper,
    val phone: InputWrapper,
    val proceed: Boolean,
    val checkBox: InputWrapper,
) {
    // такая инициализация не моя  - пропустил техлидом когда я был в лабе.компайньон обджект статика - храниться  в метаспейс
    // - насколько правильно так инициализировать?
//    возможно есть предложеня как улучшить LoginUiState или гдето почитать полезную инфу как их делать??
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