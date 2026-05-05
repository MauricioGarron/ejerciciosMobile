package com.ucb.app.profile.domain.repository

import com.ucb.app.profile.domain.model.ProfileModel

interface ProfileRepository {
    suspend fun update(profile: ProfileModel)
    suspend fun create(profile: ProfileModel)
    suspend fun findById(id: String): ProfileModel

}


///CRUD   Create, Read, Update, Delete