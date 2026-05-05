package com.ucb.app.crypto.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ucb.app.crypto.presentation.state.CryptoEffect
import com.ucb.app.crypto.presentation.viewmodel.AddCryptoViewModel
import com.ucb.app.navigation.NavRoute
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AddCryptoScreen(
    navController: NavHostController,
    viewModel: AddCryptoViewModel = koinViewModel()
) {
    var id by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var priceText by rememberSaveable { mutableStateOf("") }
    var message by rememberSaveable { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is CryptoEffect.ShowSuccess -> {
                    message = effect.message
                    navController.navigate(NavRoute.Crypto)
                }
                is CryptoEffect.ShowError -> {
                    message = effect.message
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Crear nueva crypto ficticia")

        OutlinedTextField(
            value = id,
            onValueChange = { id = it },
            label = { Text(text = "ID") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = priceText,
            onValueChange = { priceText = it },
            label = { Text(text = "Valor") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val price = priceText.toDoubleOrNull() ?: 0.0
                viewModel.saveCrypto(id = id, name = name, price = price)
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = id.isNotBlank() && name.isNotBlank()
        ) {
            Text(text = "Guardar crypto")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { navController.navigate(NavRoute.Crypto) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Ver todas las cryptos")
        }

        if (!message.isNullOrEmpty()) {
            Text(text = message!!)
        }
    }
}
