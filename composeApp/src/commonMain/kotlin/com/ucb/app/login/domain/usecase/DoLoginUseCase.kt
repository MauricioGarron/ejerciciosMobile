package com.ucb.app.login.domain.usecase

import com.ucb.app.login.domain.model.LoginModel
import com.ucb.app.login.domain.repository.AuthenticationRepository

class DoLoginUseCase(
    val repository: AuthenticationRepository
) {

    suspend fun invoke(model: LoginModel) {
        repository.login(model)
    }
}