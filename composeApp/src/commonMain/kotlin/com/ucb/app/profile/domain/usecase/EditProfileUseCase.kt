package com.ucb.app.profile.domain.usecase

import com.ucb.app.profile.domain.model.ProfileModel
import com.ucb.app.profile.domain.repository.ProfileRepository

class EditProfileUseCase(
    val repository: ProfileRepository
) {
    suspend fun invoke(model: ProfileModel) {
        repository.update(model)
    }
}