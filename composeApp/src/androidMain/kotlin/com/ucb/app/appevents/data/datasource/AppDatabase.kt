package com.ucb.app.appevents.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ucb.app.appevents.data.entity.AppEventEntity
import com.ucb.app.commonutils.data.datasource.local.RemoteConfigDao
import com.ucb.app.commonutils.data.datasource.local.RemoteConfigEntity

@Database(
    entities = [AppEventEntity::class, RemoteConfigEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appEventDao(): AppEventDao
    abstract fun remoteConfigDao(): RemoteConfigDao
}