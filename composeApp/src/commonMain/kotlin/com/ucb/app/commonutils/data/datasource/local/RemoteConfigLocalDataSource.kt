package com.ucb.app.commonutils.data.datasource.local

interface RemoteConfigLocalDataSource {
    suspend fun saveConfig(key: String, value: String)
    suspend fun getConfig(key: String): String?
    suspend fun hasConfig(key: String): Boolean
}
