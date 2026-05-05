package com.ucb.app

import android.app.Application
import com.ucb.app.appevents.AppLifecycleObserver
import com.ucb.app.di.appEventDataModule
import com.ucb.app.di.getModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AndroidApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@AndroidApp)
            modules(getModules() + appEventDataModule)
        }
        // Initialize lifecycle observer
        AppLifecycleObserver()
    }
}