package com.ucb.app.appevents.data.mapper

import com.ucb.app.appevents.data.dto.AppEventDto
import com.ucb.app.appevents.data.entity.AppEventEntity
import com.ucb.app.appevents.domain.model.AppEvent

fun AppEvent.toEntity(): AppEventEntity {
    return AppEventEntity(
        timestamp = this.timestamp,
        type = this.type,
        isSynced = false
    )
}

fun AppEvent.toDto(): AppEventDto {
    return AppEventDto(
        timestamp = this.timestamp,
        type = this.type
    )
}

fun AppEventEntity.toModel(): AppEvent {
    return AppEvent(
        timestamp = this.timestamp,
        type = this.type
    )
}

fun AppEventDto.toModel(): AppEvent {
    return AppEvent(
        timestamp = this.timestamp,
        type = this.type
    )
}