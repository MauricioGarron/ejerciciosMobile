package com.ucb.app.commonutils.domain.repository

interface ConfigRepository {
    suspend fun sync()
    suspend fun getGreetingText(): String
}