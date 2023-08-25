package com.wuyson.guidedemos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.wuyson.guidedemos.app.AppViewModel
import com.wuyson.guidedemos.ui.MainViewModel

class CustomFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return when (modelClass) {
            AppViewModel::class.java-> {
                val application = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                AppViewModel(application)
            }
            MainViewModel::class.java -> {
                val savedStateHandle = extras.createSavedStateHandle()
                MainViewModel(savedStateHandle)
            }
            else -> throw IllegalArgumentException("Unknown class $modelClass")
        } as T
    }
}
// or
val customFactory = viewModelFactory {
    // The return type of the lambda automatically sets what class this lambda handles
    initializer {
        // Get the Application object from extras provided to the lambda
        val application = checkNotNull(get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY))
        AppViewModel(application)
    }
    initializer {
        val savedStateHandle = createSavedStateHandle()
        MainViewModel(savedStateHandle)
    }
}