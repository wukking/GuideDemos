package com.wuyson.guidedemos.ui.global

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wuyson.guidedemos.App
import com.wuyson.guidedemos.app.AppDataManager
import com.wuyson.guidedemos.databinding.ActivityFirstBinding
import com.wuyson.guidedemos.databinding.ActivitySecondBinding

/**
 * @author : 𝑾𝒖 𝒀𝒂𝒏𝒔
 * @date : 2023/8/25 - 10:15
 * @description: 全局VM DEMO
 */
class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val appLevelViewModel = (application as App).appLevelViewModel
        appLevelViewModel.currentText.observe(this){
           binding.tvVmData.text = "当前VM内容：$it"
        }

        AppDataManager.data.observe(this){
            binding.tvObjData.text = "当前obj内容：$it"
        }

        binding.btnVmUpdate.setOnClickListener {
            appLevelViewModel.updateText("first-vm")
        }

        binding.btnObjUpdate.setOnClickListener {
            AppDataManager.updateData("First-obj")
        }

        binding.btnOpenNext.setOnClickListener {
            startActivity(Intent(this,SecondActivity::class.java))
        }
    }
}