package com.ucb.app.appevents.data.datasource

import com.ucb.app.appevents.data.dto.AppEventDto

expect class AppEventFirebaseDatasource() {
    suspend fun saveEvent(path: String, event: AppEventDto)
}