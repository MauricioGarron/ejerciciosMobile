package com.ucb.app.di

import com.ucb.app.appevents.data.datasource.AppEventFirebaseDatasource
import com.ucb.app.commonutils.connectivity.ConnectivityChecker
import com.ucb.app.commonutils.data.datasource.remote.RemoteConfigManager
import com.ucb.app.commonutils.data.repository.FirebaseConfigRepositoryImp
import com.ucb.app.commonutils.domain.repository.ConfigRepository
import com.ucb.app.crypto.data.datasource.RealtimeFirebaseDatasource
import com.ucb.app.crypto.data.repository.RealtimeFirebaseRepositoryImp
import com.ucb.app.crypto.domain.repository.CryptoRepository
import com.ucb.app.github.data.datasource.GithubRemoteDataSource
import com.ucb.app.github.data.repository.GithubRepositoryImpl
import com.ucb.app.github.data.service.GitHubApiService
import com.ucb.app.github.domain.repository.GithubRepository
import com.ucb.app.movie.data.datasource.MovieRemoteDatasource
import com.ucb.app.movie.data.repository.MovieRepositoryImpl
import com.ucb.app.movie.data.service.MovieService
import com.ucb.app.movie.domain.repository.MovieRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    // Instances
    singleOf(::RemoteConfigManager)
    singleOf(::RealtimeFirebaseDatasource)
    singleOf(::AppEventFirebaseDatasource)
    singleOf(::ConnectivityChecker)

    // Linking
    singleOf(::GitHubApiService).bind<GithubRemoteDataSource>()
    singleOf(::GithubRepositoryImpl).bind<GithubRepository>()
    singleOf(::MovieRepositoryImpl).bind<MovieRepository>()
    singleOf(::MovieService).bind<MovieRemoteDatasource>()
    singleOf(::RealtimeFirebaseRepositoryImp).bind<CryptoRepository>()
    singleOf(::FirebaseConfigRepositoryImp).bind<ConfigRepository>()
}