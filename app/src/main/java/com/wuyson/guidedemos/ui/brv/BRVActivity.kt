package com.wuyson.guidedemos.ui.brv

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.drake.brv.utils.linear
import com.drake.brv.utils.setup
import com.wuyson.guidedemos.R
import com.wuyson.guidedemos.databinding.ActivityBrvBinding
import com.wuyson.guidedemos.databinding.ItemSimpleList1Binding
import com.wuyson.guidedemos.databinding.ItemSimpleListBinding
import com.wuyson.guidedemos.ui.brv.bean.SimpleModel
import com.wuyson.guidedemos.ui.brv.bean.StoreModel

/**
 * @author : 𝑾𝒖 𝒀𝒂𝒏𝒔
 * @date : 2023/8/29 - 16:18
 * @description:
 */
class BRVActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBrvBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        simpleDemo()
    }

    private fun getData(): List<Any> {
        val data = mutableListOf<Any>()
        for (i in 1..10) {
            if (i == 3) {
                data.add(StoreModel("这是餐馆"))
            }
            data.add(SimpleModel("这是第${i}条数据"))
        }
        return data
    }

    private fun simpleDemo() {
        //getBinding: 获取Binding
        //getModel: 获取当前Data
        binding.rvData.linear().setup {
            addType<SimpleModel>(R.layout.item_simple_list)
            addType<StoreModel>(R.layout.item_simple_list_1)
            onBind {
                if (_data is SimpleModel) {
                    val binding = getBinding<ItemSimpleListBinding>()
                    val simpleModel = getModel<SimpleModel>()
                    binding.tvName.text = simpleModel.name
                } else if (_data is StoreModel) {
                    val storeBinding = getBinding<ItemSimpleList1Binding>()
                    val store = getModel<StoreModel>()
                    storeBinding.tvName.text = store.name
                }
            }
            onClick(R.id.tv_name) {
                if (_data is SimpleModel) {
                    val data = getModel<SimpleModel>()
                    Toast.makeText(this@BRVActivity, data.name, Toast.LENGTH_SHORT).show()
                } else if (_data is StoreModel) {
                    val data = getModel<StoreModel>()
                    Toast.makeText(this@BRVActivity, data.name, Toast.LENGTH_SHORT).show()
                }

            }
        }.models = getData()
    }
}