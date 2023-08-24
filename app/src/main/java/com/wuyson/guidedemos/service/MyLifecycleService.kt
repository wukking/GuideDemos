package com.wuyson.guidedemos.service

import android.util.Log
import androidx.lifecycle.LifecycleService

class MyLifecycleService:LifecycleService() {
    private lateinit var myObserver:MyObserver

    override fun onCreate() {
        Log.e("TAG", "MyLifecycleService#onCreate")
        super.onCreate()
        myObserver = MyObserver()
        lifecycle.addObserver(myObserver)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(myObserver)
    }
}