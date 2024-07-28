package com.vijayabhopathi.toyland.Toylanddata

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.vijayabhopathi.toyland.Toylanddata.ToylandLogin.LoginToylandUIEvent
import com.vijayabhopathi.toyland.Toylanddata.ToylandInstructions.Validator
import com.vijayabhopathi.toyland.ToylandRouting.AppRouter
import com.vijayabhopathi.toyland.ToylandRouting.Screen


class LoginToylandViewModel : ViewModel() {

    private val TAG = LoginToylandViewModel::class.simpleName

    var loginUIState = mutableStateOf(LoginToylandUIState())

    var allValidationsPassed = mutableStateOf(false)

    var loginInProgress = mutableStateOf(false)


    fun onEvent(event: LoginToylandUIEvent) {
        when (event) {
            is LoginToylandUIEvent.EmailChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )
            }

            is LoginToylandUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
            }

            is LoginToylandUIEvent.LoginButtonClicked -> {
                login()
            }
        }
        validateLoginUIDataWithRules()
    }

    private fun validateLoginUIDataWithRules() {
        val emailResult = Validator.validateEmail(
            email = loginUIState.value.email
        )


        val passwordResult = Validator.validatePassword(
            password = loginUIState.value.password
        )

        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )

        allValidationsPassed.value = emailResult.status && passwordResult.status

    }

    private fun login() {

        loginInProgress.value = true
        val email = loginUIState.value.email
        val password = loginUIState.value.password

        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG,"Inside_login_success")
                Log.d(TAG,"${it.isSuccessful}")

                if(it.isSuccessful){
                    loginInProgress.value = false
                    AppRouter.navigateTo(Screen.HomeScreen)
                }
            }
            .addOnFailureListener {
                Log.d(TAG,"Inside_login_failure")
                Log.d(TAG,"${it.localizedMessage}")

                loginInProgress.value = false

            }

    }

}


