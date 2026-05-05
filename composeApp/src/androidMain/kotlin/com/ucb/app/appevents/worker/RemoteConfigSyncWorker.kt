package com.ucb.app.appevents.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ucb.app.commonutils.domain.repository.ConfigRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RemoteConfigSyncWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams), KoinComponent {

    private val configRepository: ConfigRepository by inject()

    override suspend fun doWork(): Result {
        return try {
            configRepository.sync()
            Result.success()
        } catch (exception: Exception) {
            Result.retry()
        }
    }
}
