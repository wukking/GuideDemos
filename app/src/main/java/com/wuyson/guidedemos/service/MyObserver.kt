package com.wuyson.guidedemos.service

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

@Deprecated("")
class MyObserver : DefaultLifecycleObserver {
    private val TAG = "MyObserver"

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.e(TAG, "MyObserver#onStart")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.e(TAG, "MyObserver#onStop: ")
    }
}