package com.ucb.app.github.domain.usecase

import com.ucb.app.github.domain.model.GithubModel
import com.ucb.app.github.domain.repository.GithubRepository

class GetAvatarUseCase(
    val repository: GithubRepository
) {
    suspend fun invoke(
        model: GithubModel
    ): GithubModel {
        return repository.obtainAvatar(
            model.avatar
        )
    }
}