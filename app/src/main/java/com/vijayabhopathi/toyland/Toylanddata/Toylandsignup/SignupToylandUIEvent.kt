package  com.vijayabhopathi.toyland.Toylanddata.Toylandsignup

sealed class SignupToylandUIEvent{

    data class FirstNameChanged(val firstName:String) : SignupToylandUIEvent()
    data class LastNameChanged(val lastName:String) : SignupToylandUIEvent()
    data class EmailChanged(val email:String): SignupToylandUIEvent()
    data class PasswordChanged(val password: String) : SignupToylandUIEvent()

    data class PrivacyPolicyCheckBoxClicked(val status:Boolean) : SignupToylandUIEvent()

    object RegisterButtonClicked : SignupToylandUIEvent()
}
