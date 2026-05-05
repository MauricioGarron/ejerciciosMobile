package com.ucb.app.commonutils.data.datasource.local

class RemoteConfigLocalDataSourceImpl(
    private val dao: RemoteConfigDao
) : RemoteConfigLocalDataSource {
    override suspend fun saveConfig(key: String, value: String) {
        dao.insertConfig(RemoteConfigEntity(key = key, value = value))
    }

    override suspend fun getConfig(key: String): String? {
        return dao.getConfigValue(key)
    }

    override suspend fun hasConfig(key: String): Boolean {
        return dao.hasConfig(key)
    }
}
