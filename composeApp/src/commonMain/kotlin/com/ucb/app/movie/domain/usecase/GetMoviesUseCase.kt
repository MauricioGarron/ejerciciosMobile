package com.ucb.app.movie.domain.usecase

import com.ucb.app.movie.domain.model.MovieModel
import com.ucb.app.movie.domain.repository.MovieRepository

class GetMoviesUseCase(
    val repository: MovieRepository
) {
    suspend fun invoke(): List<MovieModel> {
        return repository.getMovies()
    }
}