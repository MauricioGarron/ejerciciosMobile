package com.ucb.app.di

import com.ucb.app.appevents.domain.usecase.SaveAppEventUseCase
import com.ucb.app.commonutils.domain.usecase.GetGreetingTextUseCase
import com.ucb.app.crypto.domain.usecase.GetCryptoUseCase
import com.ucb.app.crypto.domain.usecase.SaveCryptoUseCase
import com.ucb.app.github.domain.usecase.GetAvatarUseCase
import com.ucb.app.movie.domain.usecase.GetMoviesUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::GetAvatarUseCase)
    singleOf(::GetMoviesUseCase)
    singleOf(::GetCryptoUseCase)
    singleOf(::SaveCryptoUseCase)
    singleOf(::GetGreetingTextUseCase)
    singleOf(::SaveAppEventUseCase)
}