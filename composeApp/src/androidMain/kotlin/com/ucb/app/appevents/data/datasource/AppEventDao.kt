package com.ucb.app.appevents.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ucb.app.appevents.data.entity.AppEventEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppEventDao {
    @Insert
    suspend fun insertEvent(event: AppEventEntity): Long

    @Update
    suspend fun updateEvent(event: AppEventEntity)

    @Query("SELECT * FROM app_events ORDER BY timestamp DESC")
    fun getAllEvents(): Flow<List<AppEventEntity>>

    @Query("SELECT * FROM app_events WHERE isSynced = 0")
    suspend fun getUnsyncedEvents(): List<AppEventEntity>
}