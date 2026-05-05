package com.ucb.app.github.data.service

import com.ucb.app.github.data.datasource.GithubRemoteDataSource
import com.ucb.app.github.data.dto.UserDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class GitHubApiService: GithubRemoteDataSource {
    private val client = HttpClient{
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
    }
    override suspend fun getUser(nickname: String): UserDto {
        val response = client.get("https://api.github.com/users/$nickname")
        try {
            return response.body<UserDto>()
        } catch (e: Exception) {
            throw e
        }
    }
}