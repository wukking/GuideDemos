package com.wuyson.guidedemos

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
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
        SmartRefreshLayout.setDefaultRefreshInitializer { context, layout ->
            layout.setRefreshHeader(ClassicsHeader(context))
            layout.setRefreshFooter(ClassicsFooter(context))
        }
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