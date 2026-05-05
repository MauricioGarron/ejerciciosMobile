package com.ucb.app.movie.data.datasource

import com.ucb.app.movie.data.dto.MovieDto

interface MovieRemoteDatasource {
    suspend fun getList(): List<MovieDto>
}