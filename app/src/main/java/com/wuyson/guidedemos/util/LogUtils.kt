package com.wuyson.guidedemos.util

import android.util.Log
import com.wuyson.guidedemos.BuildConfig

object LogUtils {
    const val TAG = "LogUtils"
    fun e(msg: String?) {
        if (BuildConfig.DEBUG){
            Log.e(TAG, "e: $msg")
        }
    }
}