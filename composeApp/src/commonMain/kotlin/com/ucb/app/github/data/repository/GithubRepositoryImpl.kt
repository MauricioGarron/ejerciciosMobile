package com.ucb.app.github.data.repository

import com.ucb.app.github.data.datasource.GithubRemoteDataSource
import com.ucb.app.github.data.mapper.toModel
import com.ucb.app.github.domain.model.GithubModel
import com.ucb.app.github.domain.repository.GithubRepository

class GithubRepositoryImpl(
    val remote: GithubRemoteDataSource
): GithubRepository {
    override suspend fun obtainAvatar(avatar: String): GithubModel {
        val response = remote.getUser(avatar)
        return response.toModel()
    }
}