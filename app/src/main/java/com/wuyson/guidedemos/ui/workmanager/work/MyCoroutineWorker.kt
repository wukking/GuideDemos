package com.wuyson.guidedemos.ui.workmanager.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.wuyson.guidedemos.R
import com.wuyson.guidedemos.util.createNotification

class MyCoroutineWorker(context: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {

        try {
            //必须try-catch
            setForeground(getForegroundInfo())
        } catch (_: IllegalStateException) {
            return Result.failure()
        }

        return Result.success()
    }

    //CoroutineWorker 必须实现
    override suspend fun getForegroundInfo(): ForegroundInfo {
        return ForegroundInfo(
            WorkerNotificationIDs.COROUTINE_ID, createNotification(
                applicationContext,
                id,
                applicationContext.getString(R.string.notification_title_saving_image)
            )
        )
    }
}