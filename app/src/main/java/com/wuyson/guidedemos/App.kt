package com.wuyson.guidedemos

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.wuyson.guidedemos.viewmodel.CustomFactory

class App : Application(), ViewModelStoreOwner {
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

    //实现Application全局的ViewModel
    //直接用ViewModelStore()创建有待商榷
    private val viewModelStore = ViewModelStore()
    override fun getViewModelStore() = viewModelStore

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