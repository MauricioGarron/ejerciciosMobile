package com.ucb.app.login.domain.repository

import com.ucb.app.login.domain.model.LoginModel

interface AuthenticationRepository {
    suspend fun login(model: LoginModel)
}