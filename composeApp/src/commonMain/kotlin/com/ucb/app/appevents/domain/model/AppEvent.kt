package com.ucb.app.appevents.domain.model

data class AppEvent(
    val timestamp: Long,
    val type: String // "open" or "close"
)