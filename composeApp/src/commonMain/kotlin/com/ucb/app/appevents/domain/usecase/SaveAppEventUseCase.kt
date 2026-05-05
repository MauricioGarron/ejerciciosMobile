package com.ucb.app.appevents.domain.usecase

import com.ucb.app.appevents.domain.model.AppEvent
import com.ucb.app.appevents.domain.repository.AppEventRepository

class SaveAppEventUseCase(private val repository: AppEventRepository) {
    suspend operator fun invoke(event: AppEvent) {
        repository.saveEvent(event)
    }
}