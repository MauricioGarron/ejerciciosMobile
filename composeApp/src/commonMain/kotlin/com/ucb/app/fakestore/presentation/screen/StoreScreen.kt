package com.ucb.app.fakestore.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ucb.app.fakestore.presentation.composable.StoreContent
import com.ucb.app.fakestore.presentation.state.FakeStoreEffect
import com.ucb.app.fakestore.presentation.state.FakeStoreEvent
import com.ucb.app.fakestore.presentation.viewmodel.FakeStoreViewModel
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun StoreScreen( viewModel: FakeStoreViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onEvent(FakeStoreEvent.OnLoad)
    }

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is FakeStoreEffect.ShowError -> {
                    //show error
                }
            }
        }
    }

    when {
        state.isLoading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        state.stores.isNotEmpty() -> {
            StoreContent(state.stores)
        }

        state.error != null -> {
            Text("Error: ${state.error}")
        }
    }
}