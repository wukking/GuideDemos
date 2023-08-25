package com.wuyson.guidedemos

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.wuyson.guidedemos.app.AppLevelViewModel
import com.wuyson.guidedemos.app.AppLifecycleObserver
import com.wuyson.guidedemos.viewmodel.CustomFactory

class App : Application(){
    val appLevelViewModel by lazy {
        ViewModelProvider.AndroidViewModelFactory.getInstance(this).create(AppLevelViewModel::class.java)
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        ProcessLifecycleOwner.get().lifecycle.addObserver(AppLifecycleObserver())
    }

    companion object {
        private lateinit var context: App

        @JvmStatic
        fun getAPP(): App = context
    }

    //自定义Factory
    private lateinit var customFactory: CustomFactory
    fun viewModelProviderFactory(): CustomFactory {
        if (!::customFactory.isInitialized) {
            customFactory = CustomFactory()
        } else {
            customFactory
        }

        return customFactory
    }

}