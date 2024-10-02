package com.ass.authorization.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.ass.authorization.utils.buildTermsOfUseAndPrivacyPolicySting
import com.ass.authorization.utils.defineHasError
import com.ass.authorization.utils.getErrorText
import com.ass.core.designsystem.R
import com.ass.core.designsystem.components.checkbox.SlimCheckBox
import com.ass.core.designsystem.components.input.SlimOutlinedInputField
import com.ass.core.designsystem.components.navbar.NavBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthorizationRoute(
    navigateToBulletinScreen: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LogInViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBar(onBack = {})
            }
        ) { paddingValues ->
            Column(modifier = modifier.fillMaxSize()) {
                LogInScreen(
                    navigateToBulletinScreen = navigateToBulletinScreen,
                    uiState = uiState,
                    modifier = modifier,
                    validateInput = viewModel::validateInput,
                    paddingValues = paddingValues
                )
            }
        }
    }
}

@Composable
fun LogInScreen(
    navigateToBulletinScreen: () -> Unit,
    validateInput: (String, InputType) -> Unit,
    modifier: Modifier,
    uiState: LoginUiState,
    paddingValues: PaddingValues,
) {
    var checked by remember { mutableStateOf(value = false) }

    var emailInput by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(text = ""))
    }
    var nameInput by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(text = ""))
    }
    var secondNameInput by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(text = ""))
    }

    var phoneInput by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(text = ""))
    }

    val focusManager = LocalFocusManager.current


    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(color = Color.Cyan)
            .fillMaxWidth()
            .padding(paddingValues),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "login headline",
//                style = "AssTheme.typography.headlineSmall,",
            modifier = Modifier.padding(
                bottom = 6.dp,
                top = 6.dp,
            )
        )
        InputFields(
            uiState = uiState,
            emailInput = emailInput,
            nameInput = nameInput,
            phoneInput = phoneInput,
            secondNameInput = secondNameInput,
            errorData = uiState,
            onValueChangeEmail = { newValue ->
                emailInput = newValue
                validateInput(emailInput.text, InputType.EMAIL)
            },
            onValueChangeName = { newValue ->
                nameInput = newValue
                validateInput(nameInput.text, InputType.NAME)
            },
            onValueChangeSecondName = { newValue ->
                secondNameInput = newValue
                validateInput(secondNameInput.text, InputType.SECOND_NAME)
            },
            onValueChangePhone = { newValue ->
                phoneInput = newValue
                validateInput(phoneInput.text, InputType.PHONE)
            },
        )
        SlimCheckBox(
            onValueChange = { newValue ->
                validateInput(newValue.toString(), InputType.CHECKBOX)
                println(newValue.toString())
                checked = newValue
            },
            isChecked = checked,
            checkBoxLabel = buildTermsOfUseAndPrivacyPolicySting(
                agreementStatement = stringArrayResource(id = R.array.terms_and_policies_checkbox)[0],
                termsOfUse = stringArrayResource(id = R.array.terms_and_policies_checkbox)[1],
                conjunction = stringArrayResource(id = R.array.terms_and_policies_checkbox)[2],
                privacyPolicy = stringArrayResource(id = R.array.terms_and_policies_checkbox)[3],
                dot = stringArrayResource(id = R.array.terms_and_policies_checkbox)[4]
            )
        )
        Button(
            modifier = Modifier
                .wrapContentSize()
                .padding(top = 6.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(size = 6.dp),
            onClick = { navigateToBulletinScreen() },
            contentPadding = PaddingValues(all = 6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorScheme.secondary,
                disabledContainerColor = colorScheme.onSecondary,
                disabledContentColor = colorScheme.background
            ),
            content = { },
//            enabled = uiState.proceed
            enabled = true
        )
    }
}

@Composable
fun InputFields(
    uiState: LoginUiState,
    emailInput: TextFieldValue,
    nameInput: TextFieldValue,
    secondNameInput: TextFieldValue,
    phoneInput: TextFieldValue,
    onValueChangeName: (TextFieldValue) -> Unit,
    onValueChangeSecondName: (TextFieldValue) -> Unit,
    onValueChangePhone: (TextFieldValue) -> Unit,
    onValueChangeEmail: (TextFieldValue) -> Unit,
    errorData: LoginUiState,

    ) {
    var hideKeyboard by remember { mutableStateOf(value = false) }
    SlimOutlinedInputField(
        inputFieldValue = nameInput,
        inputFieldLabel = stringResource(id = R.string.name_label),
        onValueChange = onValueChangeName,
        hint = stringResource(id = R.string.name_hint),
        errorText = getErrorText(actionType = uiState.name.actionType, InputType.NAME).let {
            it?.let { id -> stringResource(id = id) }
        },
        hideKeyboard = hideKeyboard,
        onFocusClear = { hideKeyboard = false },
        hasError = defineHasError(errorData = errorData, inputType = InputType.NAME),
    )
    SlimOutlinedInputField(
        inputFieldValue = secondNameInput,
        inputFieldLabel = stringResource(id = R.string.second_name_label),
        onValueChange = onValueChangeSecondName,
        hint = stringResource(id = R.string.second_name_hint),
        errorText = getErrorText(
            actionType = uiState.secondName.actionType,
            InputType.SECOND_NAME
        ).let {
            it?.let { id -> stringResource(id = id) }
        },
        hideKeyboard = hideKeyboard,
        onFocusClear = { hideKeyboard = false },
        hasError = defineHasError(errorData = errorData, inputType = InputType.SECOND_NAME),
    )
    SlimOutlinedInputField(
        inputFieldValue = emailInput,
        inputFieldLabel = stringResource(id = R.string.email_label),
        onValueChange = onValueChangeEmail,
        hint = stringResource(id = R.string.email_hint),
        errorText = getErrorText(actionType = uiState.email.actionType, InputType.EMAIL).let {
            it?.let { id -> stringResource(id = id) }
        },
        hideKeyboard = hideKeyboard,
        onFocusClear = { hideKeyboard = false },
        hasError = defineHasError(errorData = errorData, inputType = InputType.EMAIL),
        keyboardType = KeyboardType.Email,
    )
    SlimOutlinedInputField(
        inputFieldValue = phoneInput,
        inputFieldLabel = stringResource(R.string.phone_label),
        onValueChange = onValueChangePhone,
        hint = stringResource(R.string.phone_hint),
        errorText = getErrorText(
            uiState.phone.actionType,
            InputType.PHONE
        )?.let { stringResource(it) },
        hideKeyboard = hideKeyboard,
        onFocusClear = { hideKeyboard = false },
        hasError = defineHasError(errorData, InputType.PHONE),
        keyboardType = KeyboardType.Phone,
        imeAction = ImeAction.Done,
    )
}

@Composable
private fun TopBar(onBack: () -> Unit) {
    NavBar(
        modifier = Modifier.background(color = colorScheme.primary),
        navIconRes = R.drawable.icon_arrow_back,
        onNavClick = onBack,
        titleText = stringResource(R.string.avalanche_ge),
    )
}