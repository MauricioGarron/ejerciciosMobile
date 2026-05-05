package com.ucb.app.profile.domain.usecase

import com.ucb.app.profile.domain.model.ProfileModel
import com.ucb.app.profile.domain.repository.ProfileRepository

class SaveProfileUseCase(
    private val repository: ProfileRepository
) {
    suspend fun invoke(profile: ProfileModel) {
        repository.create(profile)
    }
}