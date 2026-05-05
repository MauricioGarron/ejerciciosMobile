package com.ucb.app.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.app.login.domain.model.LoginModel
import com.ucb.app.login.domain.usecase.DoLoginUseCase
import com.ucb.app.login.presentation.state.LoginEffect
import com.ucb.app.login.presentation.state.LoginEvent
import com.ucb.app.login.presentation.state.LoginUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    val loginUseCase: DoLoginUseCase
): ViewModel() {

    //mutable  observable (state)
    private val _state = MutableStateFlow(LoginUiState())
    val state = _state.asStateFlow()

    //effect mutable observable ( shared)
    private val _effect = MutableSharedFlow<LoginEffect>()
    val effect = _effect.asSharedFlow()

    //events
    fun onEvent(event: LoginEvent) {
        when(event) {
            LoginEvent.OnClick -> sendLogin()
            is LoginEvent.OnEmailChanged -> TODO()
            is LoginEvent.OnPasswordChanged -> TODO()
        }
    }

    private fun sendLogin() {
        val model = LoginModel(
            _state.value.email,
            _state.value.password
        )
        viewModelScope.launch {
            loginUseCase.invoke(model)
        }

    }

    //effects
    private fun emit(effect: LoginEffect) {
        viewModelScope.launch {
            _effect.emit(effect)
        }
    }
}