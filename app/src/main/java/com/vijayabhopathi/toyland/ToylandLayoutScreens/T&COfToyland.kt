package com.vijayabhopathi.toyland.ToylandLayoutScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vijayabhopathi.toyland.R
import com.vijayabhopathi.toyland.Modules.HeadingTextComponent
import com.vijayabhopathi.toyland.Modules.NormalTextComponent
import com.vijayabhopathi.toyland.ToylandRouting.AppRouter
import com.vijayabhopathi.toyland.ToylandRouting.Screen
import com.vijayabhopathi.toyland.ToylandRouting.SystemBackButtonHandler

@Composable
fun TermsAndConditionsScreen() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)) {

        HeadingTextComponent(value = stringResource(id = R.string.terms_and_conditions_header))
        }
    NormalTextComponent(value = stringResource(id = R.string.terms_and_conditions_headerdes))

    SystemBackButtonHandler {
        AppRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable
fun TermsAndConditionsScreenPreview(){
    TermsAndConditionsScreen()
}