package com.wuyson.guidedemos.app

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author : 𝑾𝒖 𝒀𝒂𝒏𝒔
 * @date : 2023/8/25 - 9:30
 * @description:
 */
class AppLevelViewModel : ViewModel() {
    private var _count = 0
    private val _currentText = MutableLiveData("app-test")
    val currentText: LiveData<String> = _currentText

    fun updateText(newText: String) {
        _count++
        _currentText.postValue(newText + _count)
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("TAG", "AppViewModel - onCleared")
    }
}