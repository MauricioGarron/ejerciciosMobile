package com.ucb.app.commonutils.data.datasource.remote

import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.firebase.remoteconfig.remoteConfig
import kotlinx.coroutines.tasks.await

actual class RemoteConfigManager {
    private val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig

    init {
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(30)
            .build()

        remoteConfig.setConfigSettingsAsync(configSettings)

        remoteConfig.setDefaultsAsync(
            mapOf(
                "greeting_text" to "Hola desde configuración local por defecto"
            )
        )
    }

    actual suspend fun fetchAndActivate(): Boolean {
        return remoteConfig.fetchAndActivate().await()
    }

    actual fun getString(key: String): String {
        return remoteConfig.getString(key)
    }

    actual fun getBoolean(key: String): Boolean {
        return remoteConfig.getBoolean(key)
    }
}