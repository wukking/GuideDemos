package com.wuyson.guidedemos.app

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner


class AppLifecycleObserver:DefaultLifecycleObserver {

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.e("TAG", "App进入前台 ")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.e("TAG", "App进入后台 ")

    }
}