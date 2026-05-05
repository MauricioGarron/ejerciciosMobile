package com.ucb.app.signin.presentation.state

sealed interface SigninEvent {
    data class OnEmailChanged(
        val value: String
    ):SigninEvent
    data class OnPasswordChanged(
        val value:String
    ): SigninEvent
    object OnClick: SigninEvent
}