package com.wuyson.guidedemos.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(savedStateHandle: SavedStateHandle): ViewModel() {

    val listData = MutableLiveData("初始化")

    fun getData(){
        viewModelScope.launch {

        }
        liveData<String> {

        }
    }


}