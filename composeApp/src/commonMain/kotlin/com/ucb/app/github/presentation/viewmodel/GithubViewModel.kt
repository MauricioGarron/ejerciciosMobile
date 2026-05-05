package com.ucb.app.github.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.app.github.domain.model.GithubModel
import com.ucb.app.github.domain.usecase.GetAvatarUseCase
import com.ucb.app.github.presentation.state.GithubEffect
import com.ucb.app.github.presentation.state.GithubEvent
import com.ucb.app.github.presentation.state.GithubUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GithubViewModel(
    val userCase : GetAvatarUseCase
): ViewModel() {

    private val _state = MutableStateFlow(GithubUiState())
    val state = _state.asStateFlow()

    private val _effects = MutableSharedFlow<GithubEffect>()
    val effects = _effects.asSharedFlow()

    private fun emit(effect: GithubEffect) {
        viewModelScope.launch {
            _effects.emit(effect)
        }
    }

    fun onEvent(event: GithubEvent) {
        when( event) {
            is GithubEvent.OnChangeAvatar -> {
                _state.update {
                    it.copy(
                        nickname = event.value
                    )
                }
            }
            GithubEvent.OnClickFind -> findAvatar()
        }
    }

    private fun findAvatar() {
        _state.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            val model = GithubModel(
                avatar = _state.value.nickname
            )
            try {
                val response = userCase.invoke(model)

                _state.update {
                    it.copy(model = response, isLoading = false)
                }
            } catch (e: Throwable) {
                print(e.printStackTrace())
                _state.update {
                    it.copy(isLoading = false)
                }
            }
       }
    }
}