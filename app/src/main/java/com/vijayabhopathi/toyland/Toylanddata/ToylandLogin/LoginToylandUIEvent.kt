package com.vijayabhopathi.toyland.Toylanddata.ToylandLogin

sealed class LoginToylandUIEvent{

    data class EmailChanged(val email:String): LoginToylandUIEvent()
    data class PasswordChanged(val password: String) : LoginToylandUIEvent()

    object LoginButtonClicked : LoginToylandUIEvent()
}
