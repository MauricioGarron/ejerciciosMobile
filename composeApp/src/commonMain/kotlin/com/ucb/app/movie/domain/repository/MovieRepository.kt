package com.ucb.app.movie.domain.repository

import com.ucb.app.movie.domain.model.MovieModel

interface MovieRepository {
    suspend fun getMovies(): List<MovieModel>
}