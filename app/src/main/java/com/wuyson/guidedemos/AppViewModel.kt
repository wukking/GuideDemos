package com.wuyson.guidedemos

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class AppViewModel(application: Application):AndroidViewModel(application) {

    val test = MutableLiveData("app-test")

    override fun onCleared() {
        super.onCleared()
        Log.e("TAG", "AppViewModel - onCleared")
    }
}