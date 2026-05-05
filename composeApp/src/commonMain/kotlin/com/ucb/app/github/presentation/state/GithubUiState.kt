package com.ucb.app.github.presentation.state

import com.ucb.app.github.domain.model.GithubModel

data class GithubUiState(
    val isLoading: Boolean = false,
    val nickname: String = "",
    val model: GithubModel = GithubModel()
)
