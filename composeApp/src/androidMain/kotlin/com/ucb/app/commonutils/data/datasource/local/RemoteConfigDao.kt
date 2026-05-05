package com.ucb.app.commonutils.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RemoteConfigDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConfig(config: RemoteConfigEntity)

    @Query("SELECT value FROM remote_config WHERE key = :key LIMIT 1")
    suspend fun getConfigValue(key: String): String?

    @Query("SELECT COUNT(*) > 0 FROM remote_config WHERE key = :key")
    suspend fun hasConfig(key: String): Boolean
}
