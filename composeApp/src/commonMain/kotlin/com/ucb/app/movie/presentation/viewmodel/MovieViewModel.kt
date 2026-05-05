package com.ucb.app.movie.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.app.movie.domain.usecase.GetMoviesUseCase
import com.ucb.app.movie.presentation.state.MovieUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieViewModel(
    val moviesUseCase: GetMoviesUseCase
): ViewModel() {
    private val _state = MutableStateFlow(MovieUiState())
    val state = _state.asStateFlow()

    init {
        load()
    }

    fun load() {
        _state.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
           val list = moviesUseCase.invoke()
            _state.update {
                it.copy(list = list, isLoading = false)
            }
        }

    }
}