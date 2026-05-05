package com.ucb.app.signin.presentation.state

sealed interface SigninEffect {
    data class ShowError(
        val message: String
    ): SigninEffect
    object NavigateToHome: SigninEffect
}