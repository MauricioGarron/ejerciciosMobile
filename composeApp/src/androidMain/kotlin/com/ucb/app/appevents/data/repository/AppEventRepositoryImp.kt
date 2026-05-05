package com.ucb.app.appevents.data.repository

import com.ucb.app.appevents.data.datasource.AppEventDao
import com.ucb.app.appevents.data.datasource.AppEventFirebaseDatasource
import com.ucb.app.appevents.data.mapper.toDto
import com.ucb.app.appevents.data.mapper.toEntity
import com.ucb.app.appevents.domain.model.AppEvent
import com.ucb.app.appevents.domain.repository.AppEventRepository
import com.ucb.app.commonutils.connectivity.ConnectivityChecker

class AppEventRepositoryImp(
    private val dao: AppEventDao,
    private val firebaseDatasource: AppEventFirebaseDatasource,
    private val connectivityChecker: ConnectivityChecker
) : AppEventRepository {

    override suspend fun saveEvent(event: AppEvent) {
        // Save to Room
        val entity = event.toEntity()
        val id = dao.insertEvent(entity)

        // Save to Firebase if connected
        if (connectivityChecker.isConnected()) {
            try {
                firebaseDatasource.saveEvent("app_events", event.toDto())
                // Mark as synced
                dao.updateEvent(entity.copy(id = id, isSynced = true))
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}