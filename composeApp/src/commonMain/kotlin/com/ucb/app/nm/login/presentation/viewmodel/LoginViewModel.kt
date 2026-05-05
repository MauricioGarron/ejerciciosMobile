package com.ucb.app.nm.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.app.nm.login.presentation.state.LoginEffect
import com.ucb.app.nm.login.presentation.state.LoginEvent
import com.ucb.app.nm.login.presentation.state.LoginUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    //Estado
    private val _state = MutableStateFlow(LoginUiState())
    val state = _state.asStateFlow()

    // Efectos
    private val _effect = MutableSharedFlow<LoginEffect>()
    val effect = _effect.asSharedFlow()

    fun onEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.OnEmailChanged -> TODO()
            is LoginEvent.OnPasswordChanged -> TODO()
            LoginEvent.OnSignInClicked -> {
                submit()
            }
        }
    }

    private fun submit() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }
            delay(5000)
            val email = _state.value.email

            if(email.isEmpty()) {
                emit(LoginEffect.ShowError(
                    "This field can not be empty"
                ))
            }
            _state.update {
                it.copy(
                    isLoading = false
                )
            }

        }
    }

    private fun emit(effect: LoginEffect) {
        viewModelScope.launch {
            _effect.emit(effect)
        }
    }

}