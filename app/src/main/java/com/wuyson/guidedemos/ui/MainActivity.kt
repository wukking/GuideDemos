package com.wuyson.guidedemos.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.window.layout.WindowInfoTracker
import androidx.window.layout.WindowLayoutInfo
import androidx.window.layout.WindowMetricsCalculator
import com.wuyson.guidedemos.App
import com.wuyson.guidedemos.app.AppDataManager
import com.wuyson.guidedemos.adapter.MainItemAdapter
import com.wuyson.guidedemos.databinding.ActivityMainBinding
import com.wuyson.guidedemos.service.MyLifecycleService
import com.wuyson.guidedemos.ui.global.FirstActivity
import com.wuyson.guidedemos.ui.global.SecondActivity
import com.wuyson.guidedemos.viewmodel.CustomFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var windowInfoTracker: WindowInfoTracker

    //    private lateinit var viewModel:MainViewModel
    private val viewModel by viewModels<MainViewModel> { CustomFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        viewModel = ViewModelProvider(this,CustomFactory())[MainViewModel::class.java]

        windowInfoTracker = WindowInfoTracker.getOrCreate(this)
        obtainWindowMetrics()
        onWindowLayoutInfoChange()

        val datas = mutableListOf(
            "TextView",
            "Button"
        )

        binding.rvData.apply {
            adapter = MainItemAdapter(datas)
        }

        startService(Intent(this, MyLifecycleService::class.java))

        binding.btnOpenAppDemo.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }
    }

    //Window Manager Code [没有折叠屏，还没测]
    private fun obtainWindowMetrics() {
        val wwm = WindowMetricsCalculator.getOrCreate()
        val currentWM = wwm.computeCurrentWindowMetrics(this).bounds.flattenToString()
        val maximumWM = wwm.computeMaximumWindowMetrics(this).bounds.flattenToString()
        binding.windowMetrics.text =
            "CurrentWindowMetrics: ${currentWM}\nMaximumWindwoMetrics: $maximumWM"
    }

    private fun onWindowLayoutInfoChange() {
        lifecycleScope.launch(Dispatchers.Main) {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                windowInfoTracker.windowLayoutInfo(this@MainActivity).collect { values ->
                    updateUI(values)
                }
            }
        }
    }

    private fun updateUI(newLayoutInfo: WindowLayoutInfo) {
        //只有在应用在运行时占满逻辑显示屏、与设备功能（折叠边或合页）互动的情况下，您才会获得 WindowLayoutInfo 数据
        binding.layoutChange.text = newLayoutInfo.toString()
        if (newLayoutInfo.displayFeatures.isNotEmpty()) {
            binding.configurationChanged.text = "Spanned across displays"

        } else {
            binding.configurationChanged.text = "One logic/physical display - unspanned"
        }
    }

}