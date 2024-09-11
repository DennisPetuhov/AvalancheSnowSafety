package com.ass.authorization.utils


import android.util.Patterns.EMAIL_ADDRESS
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.ass.authorization.ui.ActionType
import com.ass.authorization.ui.InputType
import com.ass.authorization.ui.LoginUiState
import com.ass.core.designsystem.R
import java.util.regex.Pattern

const val NAME_PATTERN = "^[A-Za-z]?$"
const val PHONE_PATTERN = "^[0-9]{6,}$"
fun buildTermsOfUseAndPrivacyPolicySting(
    agreementStatement: String,
    termsOfUse: String,
    conjunction: String,
    privacyPolicy: String,
    dot: String,
): AnnotatedString {
    return buildAnnotatedString {
        append(agreementStatement)
        pushStringAnnotation(tag = termsOfUse, annotation = "")
        withStyle(
            style = SpanStyle(
                fontWeight = null,
                letterSpacing = 2.sp,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(termsOfUse)
        }
        pop()
        append(conjunction)
        pushStringAnnotation(tag = privacyPolicy, annotation = "")
        withStyle(
            style = SpanStyle(
                fontWeight = null,
                letterSpacing = 2.sp,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(privacyPolicy)
        }
        pop()
        append(dot)
    }
}

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