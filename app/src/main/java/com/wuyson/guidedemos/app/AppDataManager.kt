package com.wuyson.guidedemos.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * App全局data
 */
@Deprecated("")
object AppDataManager {
    private var _count = 0
    private val _data = MutableLiveData<String>()

    val data: LiveData<String> = _data

    fun updateData(newData: String) {
        _count++
        _data.value = newData + _count
    }
}