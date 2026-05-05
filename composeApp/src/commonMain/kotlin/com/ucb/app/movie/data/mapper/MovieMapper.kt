package com.ucb.app.movie.data.mapper

import com.ucb.app.movie.data.dto.MovieDto
import com.ucb.app.movie.domain.model.MovieModel

fun MovieDto.toModel() = MovieModel(
    description = "",
    pathUrl = "https://image.tmdb.org/t/p/w185$posterPath",
    title = title
)
