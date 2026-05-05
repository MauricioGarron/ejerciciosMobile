package com.ucb.app.movie.data.repository

import com.ucb.app.movie.data.datasource.MovieRemoteDatasource
import com.ucb.app.movie.data.mapper.toModel
import com.ucb.app.movie.domain.model.MovieModel
import com.ucb.app.movie.domain.repository.MovieRepository

class MovieRepositoryImpl(
    val remote: MovieRemoteDatasource
): MovieRepository {
    override suspend fun getMovies(): List<MovieModel> {
        val response = remote.getList()
        return response.map { it.toModel() }
    }
}