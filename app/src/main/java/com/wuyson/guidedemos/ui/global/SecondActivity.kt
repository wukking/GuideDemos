package com.wuyson.guidedemos.ui.global

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wuyson.guidedemos.App
import com.wuyson.guidedemos.app.AppDataManager
import com.wuyson.guidedemos.databinding.ActivitySecondBinding

/**
 * @author : 𝑾𝒖 𝒀𝒂𝒏𝒔
 * @date : 2023/8/25 - 10:15
 * @description:
 */
class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val appLevelViewModel = (application as App).appLevelViewModel
        appLevelViewModel.currentText.observe(this) {
            binding.tvVmData.text = "当前VM内容: ${it}"
        }

        AppDataManager.data.observe(this){
            binding.tvObjData.text = "当前OBJ内容: ${it}"
        }

        binding.btnVmUpdate.setOnClickListener {
            appLevelViewModel.updateText("second-vm")
        }

        binding.btnObjUpdate.setOnClickListener {
            AppDataManager.updateData("second-obj")
        }

    }
}