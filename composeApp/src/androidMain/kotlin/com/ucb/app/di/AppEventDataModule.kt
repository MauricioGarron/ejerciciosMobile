package com.ucb.app.di

import androidx.room.Room
import androidx.work.WorkManager
import com.ucb.app.appevents.data.datasource.AppDatabase
import com.ucb.app.appevents.data.datasource.AppEventDao
import com.ucb.app.appevents.data.datasource.AppEventFirebaseDatasource
import com.ucb.app.appevents.data.repository.AppEventRepositoryImp
import com.ucb.app.appevents.domain.repository.AppEventRepository
import com.ucb.app.commonutils.connectivity.ConnectivityChecker
import com.ucb.app.commonutils.data.datasource.local.RemoteConfigDao
import com.ucb.app.commonutils.data.datasource.local.RemoteConfigLocalDataSource
import com.ucb.app.commonutils.data.datasource.local.RemoteConfigLocalDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appEventDataModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "app_events.db"
        ).fallbackToDestructiveMigration().build()
    }
    single<AppEventDao> { get<AppDatabase>().appEventDao() }
    single<RemoteConfigDao> { get<AppDatabase>().remoteConfigDao() }
    single<RemoteConfigLocalDataSource> { RemoteConfigLocalDataSourceImpl(get()) }
    singleOf(::AppEventFirebaseDatasource)
    singleOf(::ConnectivityChecker)
    single { WorkManager.getInstance(androidContext()) }
    singleOf(::AppEventRepositoryImp).bind<AppEventRepository>()
}