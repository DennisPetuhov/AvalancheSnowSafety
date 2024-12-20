package com.ass.authorization.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ass.authorization.utils.defineHasError
import com.ass.authorization.utils.getErrorText
import com.ass.core.designsystem.R
import com.ass.core.designsystem.components.checkbox.SlimCheckBox
import com.ass.core.designsystem.components.input.SlimOutlinedInputField
import com.ass.core.designsystem.components.navbar.AssTopBar
import com.ass.core.designsystem.theme.AssAlpha
import com.ass.core.designsystem.theme.AssCornerRadius
import com.ass.core.designsystem.theme.AssPaddings
import com.ass.core.designsystem.theme.AssTheme
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
            topBar = { TopBar() }
        ) { paddingValues ->
            LogInScreen(
                navigateToBulletinScreen = navigateToBulletinScreen,
                uiState = uiState,
                modifier = modifier,
                validateInput = viewModel::validateInput,
                saveUser = viewModel::saveUser,
                paddingValues = paddingValues,
            )
        }
    }
}

@Composable
fun LogInScreen(
    saveUser: (name: String, secondName: String, email: String, phone: String) -> Unit,
    navigateToBulletinScreen: () -> Unit,
    validateInput: (String, InputType) -> Unit,
    modifier: Modifier = Modifier,
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
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(AssPaddings.padding16dp)
            .padding(paddingValues)
            .border(1.dp, colorScheme.primary, RoundedCornerShape(16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier
                .fillMaxSize()
                .padding(AssPaddings.padding20dp)
        ) {
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
            Spacer(modifier = Modifier.padding(AssPaddings.padding16dp))
            Text(
                text = stringResource(R.string.disclaimer),
                style = AssTheme.typography.labelLarge,
                color = AssTheme.colorScheme.secondary,
                modifier = Modifier.padding(horizontal = AssPaddings.padding20dp),

                )
            Spacer(modifier = Modifier.padding(AssPaddings.padding40dp))
            SlimCheckBox(
                onValueChange = { newValue ->
                    validateInput(newValue.toString(), InputType.CHECKBOX)
                    checked = newValue
                },
                isChecked = checked
            )
            Spacer(modifier = Modifier.padding(AssPaddings.padding16dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(size = AssCornerRadius.cornerRadius32dp),
                onClick = {
                    saveUser(
                        nameInput.text,
                        secondNameInput.text,
                        emailInput.text,
                        phoneInput.text
                    )
                    navigateToBulletinScreen()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = AssTheme.colorScheme.avalancheDangerLevel3,
                    disabledContainerColor = AssTheme.colorScheme.secondary.copy(alpha = AssAlpha.alpha05),
                    disabledContentColor = AssTheme.colorScheme.background
                ),
                content = {
                    Text(
                        text = stringResource(R.string.sign_up),
                        style = AssTheme.typography.labelLarge
                    )
                },
                enabled = uiState.proceed
            )
        }
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
    errorData: LoginUiState
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
private fun TopBar() {
    AssTopBar(
        modifier = Modifier.background(color = colorScheme.primary),
        onNavClick = {},
        titleText = R.string.avalanche_ge,
    )
}

@Preview(showSystemUi = true)
@Composable
fun LogInScreenPreview() {
    LogInScreen(
        navigateToBulletinScreen = {},
        validateInput = { input, inputType -> },
        uiState = LoginUiState.empty,
        paddingValues = PaddingValues(0.dp),
        saveUser = { name, secondName, email, phone -> },
    )
}