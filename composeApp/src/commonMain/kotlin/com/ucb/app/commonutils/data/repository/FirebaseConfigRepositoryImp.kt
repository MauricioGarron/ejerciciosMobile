package com.ucb.app.commonutils.data.repository

import com.ucb.app.commonutils.connectivity.ConnectivityChecker
import com.ucb.app.commonutils.data.datasource.local.RemoteConfigLocalDataSource
import com.ucb.app.commonutils.data.datasource.remote.RemoteConfigManager
import com.ucb.app.commonutils.domain.repository.ConfigRepository

class FirebaseConfigRepositoryImp(
    private val remoteConfig: RemoteConfigManager,
    private val localDataSource: RemoteConfigLocalDataSource,
    private val connectivityChecker: ConnectivityChecker
) : ConfigRepository {

    private val configKeys = listOf("greeting_text")

    override suspend fun sync() {
        if (!connectivityChecker.isConnected()) return

        if (remoteConfig.fetchAndActivate()) {
            configKeys.forEach { key ->
                val value = remoteConfig.getString(key)
                localDataSource.saveConfig(key, value)
            }
        }
    }

    override suspend fun getGreetingText(): String {
        if (connectivityChecker.isConnected()) {
            sync()
        }
        return localDataSource.getConfig("greeting_text")
            ?: remoteConfig.getString("greeting_text")
    }
}