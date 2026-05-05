package com.ucb.app.signin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.app.signin.presentation.state.SigninEffect
import com.ucb.app.signin.presentation.state.SigninEvent
import com.ucb.app.signin.presentation.state.SigninUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SigninViewModel: ViewModel() {

    // mutable
    private val _state = MutableStateFlow<SigninUiState>(SigninUiState())

    // observable
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<SigninEffect>()
    val effect = _effect.asSharedFlow()

    //events
    fun onEvent(event: SigninEvent) {
        when(event){
            SigninEvent.OnClick -> TODO()
            is SigninEvent.OnEmailChanged -> TODO()
            is SigninEvent.OnPasswordChanged -> TODO()
        }
    }

    //efectos
    private fun emit(effect: SigninEffect) {
       viewModelScope.launch {
           _effect.emit(effect)
       }
    }
}