package com.vijayabhopathi.toyland.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vijayabhopathi.toyland.Toylanddata.Toylandhome.ToyViewModel
import com.vijayabhopathi.toyland.ToylandRouting.AppRouter
import com.vijayabhopathi.toyland.ToylandRouting.Screen
import com.vijayabhopathi.toyland.ToylandLayoutScreens.HomeScreen
import com.vijayabhopathi.toyland.ToylandLayoutScreens.LoginScreen
import com.vijayabhopathi.toyland.ToylandLayoutScreens.SignUpScreen
import com.vijayabhopathi.toyland.ToylandLayoutScreens.TermsAndConditionsScreen


@Composable
fun ToyApps(homeViewModel: ToyViewModel = viewModel()) {

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray
    ) {

        if (homeViewModel.isUserLoggedIn.value == true) {
            AppRouter.navigateTo(Screen.HomeScreen)
        }

        Crossfade(targetState = AppRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }
            }
        }

    }
}