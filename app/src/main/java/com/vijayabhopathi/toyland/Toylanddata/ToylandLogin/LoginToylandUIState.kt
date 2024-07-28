package com.vijayabhopathi.toyland.Toylanddata

data class LoginToylandUIState(
    var email  :String = "",
    var password  :String = "",

    var emailError :Boolean = false,
    var passwordError : Boolean = false

)
