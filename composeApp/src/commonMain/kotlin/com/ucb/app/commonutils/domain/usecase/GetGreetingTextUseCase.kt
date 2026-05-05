package com.ucb.app.commonutils.domain.usecase

import com.ucb.app.commonutils.domain.repository.ConfigRepository

class GetGreetingTextUseCase (
    private val repository: ConfigRepository
) {
    suspend operator fun invoke(): String {
        return repository.getGreetingText()
    }
}