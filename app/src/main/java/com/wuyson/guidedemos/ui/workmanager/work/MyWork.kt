package com.wuyson.guidedemos.ui.workmanager.work

import android.content.Context
import androidx.work.Data
import androidx.work.ForegroundInfo
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.common.util.concurrent.ListenableFuture

class MyWork(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {

//        获取输入数据
//        val inputData  = inputData.getString("inputData")

        //do somethings
        //...

        //输入数据
//        val outData = Data.Builder().putString("outData","执行成功").build()
//        return Result.success(outData)

        return Result.success()
    }

    //加急任务，要实现以下两个方法，在android12 可以展示通知

    //加急任务必须实现这个方法，如果没实现这个方法，在低于12上可能出现奔溃
    override fun getForegroundInfo(): ForegroundInfo {
        return super.getForegroundInfo()
    }

    override fun getForegroundInfoAsync(): ListenableFuture<ForegroundInfo> {
        return super.getForegroundInfoAsync()
    }
}