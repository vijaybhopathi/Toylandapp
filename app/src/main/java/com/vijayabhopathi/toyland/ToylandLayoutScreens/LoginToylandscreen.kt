package com.vijayabhopathi.toyland.ToylandLayoutScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.vijayabhopathi.toyland.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vijayabhopathi.toyland.Modules.ButtonComponent
import com.vijayabhopathi.toyland.Modules.ClickableLoginTextComponent
import com.vijayabhopathi.toyland.Modules.DividerTextComponent
import com.vijayabhopathi.toyland.Modules.HeadingTextComponent
import com.vijayabhopathi.toyland.Modules.MyTextFieldComponent
import com.vijayabhopathi.toyland.Modules.PasswordTextFieldComponent
import com.vijayabhopathi.toyland.Toylanddata.LoginToylandViewModel
import com.vijayabhopathi.toyland.Toylanddata.ToylandLogin.LoginToylandUIEvent
import com.vijayabhopathi.toyland.ToylandRouting.AppRouter
import com.vijayabhopathi.toyland.ToylandRouting.Screen
import com.vijayabhopathi.toyland.ToylandRouting.SystemBackButtonHandler


@Composable
fun LoginScreen(loginViewModel: LoginToylandViewModel = viewModel()) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {

            Column( modifier = Modifier.fillMaxSize()) {

                Spacer(modifier = Modifier.height(20.dp))
                HeadingTextComponent(value = "Login")
                Spacer(modifier = Modifier.height(20.dp))

                MyTextFieldComponent(labelValue = stringResource(id = R.string.email),
                    painterResource(id = R.drawable.message),
                    onTextChanged = { loginViewModel.onEvent(LoginToylandUIEvent.EmailChanged(it)) },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )

                PasswordTextFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    painterResource(id = R.drawable.lock),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginToylandUIEvent.PasswordChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )

                Spacer(modifier = Modifier.height(40.dp))

                Spacer(modifier = Modifier.height(40.dp))

                ButtonComponent(
                    value = stringResource(id = R.string.login),
                    onButtonClicked = {
                       loginViewModel.onEvent(LoginToylandUIEvent.LoginButtonClicked)
                    },
                    isEnabled = loginViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(20.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    AppRouter.navigateTo(Screen.SignUpScreen)
                })
            }
        }

        if(loginViewModel.loginInProgress.value) {
            CircularProgressIndicator()
        }
    }

    SystemBackButtonHandler {
        AppRouter.navigateTo(Screen.SignUpScreen)
    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

