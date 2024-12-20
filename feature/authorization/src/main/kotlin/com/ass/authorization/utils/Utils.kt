package com.ass.authorization.utils


import android.util.Patterns.EMAIL_ADDRESS
import com.ass.authorization.ui.screens.login.ActionType
import com.ass.authorization.ui.screens.login.InputType
import com.ass.authorization.ui.screens.login.LoginUiState
import com.ass.core.designsystem.R
import java.util.regex.Pattern

const val NAME_PATTERN = "^[A-Za-z]?$"
const val PHONE_PATTERN = "^[0-9]{6,}$"
const val SPLASH_SCREEN_DELAY = 2000L
fun getErrorText(actionType: ActionType?, inputType: InputType): Int? {
    return if (actionType == ActionType.NotifyWrongFormat) {
        when (inputType) {
            InputType.EMAIL -> R.string.email_wrong_format
            InputType.NAME -> R.string.name_wrong_format
            InputType.PHONE -> R.string.phone_wrong_format
            InputType.SECOND_NAME -> R.string.second_name_wrong_format
            InputType.CHECKBOX -> R.string.second_name_wrong_format
        }
    } else null
}

fun defineHasError(errorData: LoginUiState, inputType: InputType): Boolean {
    return errorData.let {
        when (inputType) {
            InputType.EMAIL -> errorData.email.hasError
            InputType.NAME -> errorData.name.hasError
            InputType.SECOND_NAME -> errorData.secondName.hasError
            InputType.PHONE -> errorData.phone.hasError
            InputType.CHECKBOX -> errorData.proceed
        }
    }
}

fun isValidPhone(phone: String): Boolean {
    val pattern = Pattern.compile(PHONE_PATTERN)
    val matcher = pattern.matcher(phone)
    return !matcher.matches()
}

fun isValidEmail(field: String): Boolean {
    val pattern = EMAIL_ADDRESS
    val matcher = pattern.matcher(field)
    return !matcher.matches()
}

fun isValidName(name: String): Boolean {
    val pattern = Pattern.compile(NAME_PATTERN)
    val matcher = pattern.matcher(name)
    return matcher.matches()
}

fun isValidCheckBox(value: String): Boolean {
    return when (value.lowercase()) {
        "true" -> false
        "false" -> true
        else -> throw IllegalArgumentException("Invalid input: $value. Expected 'true' or 'false'.")
    }
}