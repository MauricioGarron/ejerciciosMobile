package com.ucb.app.country.presentation.state

sealed interface CountryEvent {
    data object OnLoad : CountryEvent
    data object OnRefresh : CountryEvent
}