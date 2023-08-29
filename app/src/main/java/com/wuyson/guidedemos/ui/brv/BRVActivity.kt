package com.wuyson.guidedemos.ui.brv

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.drake.brv.utils.linear
import com.drake.brv.utils.setup
import com.wuyson.guidedemos.R
import com.wuyson.guidedemos.databinding.ActivityBrvBinding
import com.wuyson.guidedemos.databinding.ItemSimpleListBinding
import com.wuyson.guidedemos.ui.brv.bean.SimpleModel

/**
 * @author : 𝑾𝒖 𝒀𝒂𝒏𝒔
 * @date : 2023/8/29 - 16:18
 * @description:
 */
class BRVActivity : AppCompatActivity() {

    private lateinit var binding:ActivityBrvBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        simpleDemo()
    }

    private fun getData():List<SimpleModel>{
        val data = mutableListOf<SimpleModel>()
        for (i in 1..10){
            data.add(SimpleModel("这是第${i}条数据"))
        }
        return data
    }

    private fun simpleDemo(){
        binding.rvData.linear().setup {
            addType<SimpleModel>(R.layout.item_simple_list)
            onBind {
                val binding = getBinding<ItemSimpleListBinding>()
                val data = getModel<SimpleModel>()
                binding.tvName.text = data.name
            }
            onClick(R.id.tv_name){
                Toast.makeText(this@BRVActivity, getModel<SimpleModel>().name, Toast.LENGTH_SHORT).show()
            }
        }.models = getData()
    }
}