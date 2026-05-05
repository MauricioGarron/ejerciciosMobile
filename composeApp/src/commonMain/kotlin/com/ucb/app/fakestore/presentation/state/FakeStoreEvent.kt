package com.ucb.app.fakestore.presentation.state

sealed interface FakeStoreEvent {
    data object OnLoad : FakeStoreEvent
    data object OnRefresh : FakeStoreEvent
}