package com.ucb.app.crypto.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ucb.app.crypto.presentation.composable.CryptoContent
import com.ucb.app.crypto.presentation.state.CryptoEffect
import com.ucb.app.crypto.presentation.state.CryptoEvent
import com.ucb.app.crypto.presentation.viewmodel.CryptoViewModel
import com.ucb.app.navigation.NavRoute
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CryptoScreen(
    navController: NavHostController,
    viewModel: CryptoViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onEvent(CryptoEvent.OnLoad)
    }

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is CryptoEffect.ShowError -> {

                }
                is CryptoEffect.ShowSuccess -> TODO()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(
            onClick = {
                navController.navigate(NavRoute.AddCrypto)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Crear crypto ficticia")
        }

        Text(text = "Configuración: ${state.greeting}")

        when {
            state.isLoading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            state.cryptos.isNotEmpty() -> {
                CryptoContent(state.cryptos)
            }
            state.error != null -> {
                Text("Error: ${state.error}")
            }
            else -> {
                Text("No hay criptomonedas guardadas. Usa el botón para crear una.")
            }
        }
    }
}