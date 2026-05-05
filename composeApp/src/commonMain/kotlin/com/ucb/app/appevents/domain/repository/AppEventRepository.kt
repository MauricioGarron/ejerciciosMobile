package com.ucb.app.appevents.domain.repository

import com.ucb.app.appevents.domain.model.AppEvent

interface AppEventRepository {
    suspend fun saveEvent(event: AppEvent)
}