package com.ucb.app.github.data.mapper

import com.ucb.app.github.data.dto.UserDto
import com.ucb.app.github.domain.model.GithubModel

fun UserDto.toModel() = GithubModel(
    name = name?:"",
    urlImage=avatarUrl,
    avatar = login,
    bio = bio ?: "",
    company = company ?: ""
)