package com.wuyson.guidedemos.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    var count = 0

    val test = MutableLiveData("app-test")

    fun updateText(newText: String) {
        count++
        test.value = newText + count
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("TAG", "AppViewModel - onCleared")
    }
}