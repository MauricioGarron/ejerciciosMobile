package com.ucb.app.fakestore.presentation.state

sealed interface FakeStoreEffect {
    data class ShowError(val message: String) : FakeStoreEffect
}