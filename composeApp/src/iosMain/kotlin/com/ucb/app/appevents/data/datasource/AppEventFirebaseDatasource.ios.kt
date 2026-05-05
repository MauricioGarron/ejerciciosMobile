package com.ucb.app.appevents.data.datasource

import com.ucb.app.appevents.data.dto.AppEventDto

actual class AppEventFirebaseDatasource actual constructor() {
    actual suspend fun saveEvent(
        path: String,
        event: AppEventDto
    ) {
    }
}