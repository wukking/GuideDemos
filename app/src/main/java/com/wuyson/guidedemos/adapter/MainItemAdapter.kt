package com.wuyson.guidedemos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wuyson.guidedemos.databinding.ItemMainItemListBinding

class MainItemAdapter(private val data: MutableList<String>?) :
    RecyclerView.Adapter<MainItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemViewHolder {
        val binding = ItemMainItemListBinding.inflate(LayoutInflater.from(parent.context))
        return MainItemViewHolder(binding)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MainItemViewHolder, position: Int) {
        data?.let { bean ->
            holder.bind(bean[position])
        }
    }
}

class MainItemViewHolder(private val binding: ItemMainItemListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: String) {
        binding.btnItem.text = item
    }
}

