package com.ucb.app.country.presentation.state

sealed interface CountryEffect {
    data class ShowError(val message: String) : CountryEffect
}