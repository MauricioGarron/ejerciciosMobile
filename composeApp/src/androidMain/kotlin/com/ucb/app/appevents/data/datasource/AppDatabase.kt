package com.ucb.app.appevents.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ucb.app.appevents.data.entity.AppEventEntity
import com.ucb.app.commonutils.data.datasource.local.RemoteConfigDao
import com.ucb.app.commonutils.data.datasource.local.RemoteConfigEntity
import com.ucb.app.crypto.data.local.CryptoDraftDao
import com.ucb.app.crypto.data.local.CryptoDraftEntity

@Database(
    entities = [
        AppEventEntity::class,
        RemoteConfigEntity::class,
        CryptoDraftEntity::class
    ],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appEventDao(): AppEventDao
    abstract fun remoteConfigDao(): RemoteConfigDao
    abstract fun cryptoDraftDao(): CryptoDraftDao
}