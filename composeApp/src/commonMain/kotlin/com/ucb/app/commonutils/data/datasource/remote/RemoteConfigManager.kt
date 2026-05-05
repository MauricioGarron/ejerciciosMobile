package com.ucb.app.commonutils.data.datasource.remote

expect class RemoteConfigManager() {
    suspend fun fetchAndActivate(): Boolean
    fun getString(key: String): String
    fun getBoolean(key: String): Boolean
}