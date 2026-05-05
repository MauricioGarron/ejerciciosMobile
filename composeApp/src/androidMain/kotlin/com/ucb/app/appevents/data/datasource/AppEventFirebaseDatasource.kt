package com.ucb.app.appevents.data.datasource

import com.google.firebase.database.FirebaseDatabase
import com.ucb.app.appevents.data.dto.AppEventDto
import kotlinx.coroutines.tasks.await

actual class AppEventFirebaseDatasource actual constructor() {
    private val database = FirebaseDatabase.getInstance()

    actual suspend fun saveEvent(path: String, event: AppEventDto) {
        val ref = database.getReference(path)
        ref.push().setValue(event).await()
    }
}