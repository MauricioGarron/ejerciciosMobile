package com.ucb.app.github.domain.repository

import com.ucb.app.github.domain.model.GithubModel

interface GithubRepository {
    suspend fun obtainAvatar(
        avatar: String
    ): GithubModel
}