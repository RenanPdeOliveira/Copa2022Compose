package me.dio.copa.catar.notification.scheduler.extensions

import android.content.Context
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import me.dio.copa.catar.domain.model.MatchDomain
import java.time.Duration
import java.time.LocalDateTime

class NotificationMatchWorker(
    private val context: Context,
    workerParameters: WorkerParameters
): Worker(context, workerParameters) {
    override fun doWork(): Result {
        val title = inputData.getString(NOTIFICATION_TITLE_KEY)
            ?: throw IllegalArgumentException("Title is required")
        val content = inputData.getString(NOTIFICATION_CONTENT_KEY)
            ?: throw IllegalArgumentException("Content is required")
        context.showNotification(title, content)
        return Result.success()
    }

    companion object {
        private const val NOTIFICATION_TITLE_KEY = "NOTIFICATION_TITLE_KEY"
        private const val NOTIFICATION_CONTENT_KEY = "NOTIFICATION_CONTENT_KEY"

        fun start(context: Context, match: MatchDomain) {
            val initialDelay = Duration.between(LocalDateTime.now(), match.date).minusMinutes(5)
            val inputData = workDataOf(
                NOTIFICATION_TITLE_KEY to "Se prepare que o jogo vai comecar",
                NOTIFICATION_CONTENT_KEY to "Hoje tem ${match.team1} x ${match.team2}"
            )

            WorkManager.getInstance(context)
                .enqueueUniqueWork(
                    match.id,
                    ExistingWorkPolicy.KEEP,
                    OneTimeWorkRequestBuilder<NotificationMatchWorker>()
                        .setInitialDelay(initialDelay)
                        .setInputData(inputData)
                        .build()
                )
        }

        fun cancel(context: Context, match: MatchDomain) {
            WorkManager.getInstance(context)
                .cancelUniqueWork(match.id)
        }
    }
}