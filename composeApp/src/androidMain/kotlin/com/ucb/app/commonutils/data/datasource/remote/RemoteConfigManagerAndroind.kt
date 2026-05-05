package com.ucb.app.commonutils.data.datasource.remote

import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.remoteConfig
import kotlinx.coroutines.tasks.await

actual class RemoteConfigManager {
    private val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig

    init {
        val configSettings = com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(30) // 30 seg
            .build()

        remoteConfig.setConfigSettingsAsync(configSettings)

        remoteConfig.setDefaultsAsync(
            mapOf(
                "feature_enabled" to false,
                "welcome_text" to "Hola default"
            )
        )
    }

    actual suspend fun fetchAndActivate(): Boolean {
        return remoteConfig.fetchAndActivate().await()
    }

    actual fun getString(key: String): String {
        remoteConfig.fetchAndActivate()
        return remoteConfig.getString(key)
    }

    actual fun getBoolean(key: String): Boolean {
        remoteConfig.fetchAndActivate()
        return remoteConfig.getBoolean(key)
    }
}