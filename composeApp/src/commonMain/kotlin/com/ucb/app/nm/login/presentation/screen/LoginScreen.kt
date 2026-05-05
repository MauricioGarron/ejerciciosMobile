package com.ucb.app.nm.login.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ucb.app.nm.login.presentation.state.LoginEffect
import com.ucb.app.nm.login.presentation.state.LoginEvent
import com.ucb.app.nm.login.presentation.viewmodel.LoginViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    snackbarHostState: SnackbarHostState,
    viewModel: LoginViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.effect.collect {
            effect ->
            when(effect) {
                LoginEffect.NavigateToHome -> TODO()
                is LoginEffect.ShowError -> {
                    snackbarHostState.showSnackbar(effect.message,
                        withDismissAction = true)
                }
            }
        }
    }



    Column {
        TextField(
            label = { Text("Email:") },
            value = state.value.email,
            onValueChange = {
                viewModel.onEvent(LoginEvent.OnEmailChanged(
                    it
                ))
            }
        )
        OutlinedTextField(
            label = {
                Text("Password:")
            },
            value = state.value.password,
            onValueChange = {
                viewModel.onEvent(
                    LoginEvent.OnPasswordChanged(it)
                )
            }
        )
        Button(
            onClick = {
                viewModel.onEvent(LoginEvent.OnSignInClicked)
            },
            enabled = !state.value.isLoading
        ) {
            if(state.value.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                    strokeWidth = 2.dp
                )
            } else {
                Text("Sign in")
            }

        }
    }
}