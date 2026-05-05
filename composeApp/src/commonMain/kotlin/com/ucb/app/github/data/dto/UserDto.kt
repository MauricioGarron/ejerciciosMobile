package com.ucb.app.github.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val login: String,
    @SerialName("avatar_url")
    val avatarUrl: String,
    val name: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    val bio: String ? = null,
    val company: String? = null
)
