package com.wuyson.guidedemos.ui.workmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.wuyson.guidedemos.databinding.ActivityWorkManagerBinding
import com.wuyson.guidedemos.ui.workmanager.work.MyWork

@Deprecated("")
class WorkManagerActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWorkManagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun demo01(){
        //创建request：第一种 from
        val myWork01 = OneTimeWorkRequest.from(MyWork::class.java)

        //创建request：第二种 builder
        val inputData = Data.Builder()
            .putString("inputData","开始任务")
            .build()

        val myWork02 = OneTimeWorkRequestBuilder<MyWork>()
            .setInputData(inputData) //输入数据
            .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) //加急：配额用完转为普通任务
//            .setExpedited(OutOfQuotaPolicy.DROP_WORK_REQUEST)//加急：配额用完取消任务
            .build()

        WorkManager.getInstance(this).enqueue(myWork02)

        //监听任务状态
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(myWork01.id).observe(this){workInfo ->
            if (workInfo.state == WorkInfo.State.SUCCEEDED){
                val outData = workInfo.outputData.getString("outputData")
            }
        }

    }
}