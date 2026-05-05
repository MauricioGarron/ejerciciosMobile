package com.ucb.app.github.data.datasource

import com.ucb.app.github.data.dto.UserDto

interface GithubRemoteDataSource {
    suspend fun getUser(nickname: String): UserDto
}