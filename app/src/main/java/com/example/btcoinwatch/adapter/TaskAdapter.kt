package com.example.btcoinwatch.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.btcoinwatch.R
import com.example.btcoinwatch.net.bean.Task

class TaskAdapter:BaseQuickAdapter<Task,BaseViewHolder>(R.layout.item_task_parent) {
    override fun convert(holder: BaseViewHolder, item: Task) {
        holder.setText(R.id.title,item.usdt)
//        holder.setText(R.id.desc, if (item.desc1.isNullOrBlank()) "此单暂无描述" else item.desc1)
        holder.setText(R.id.type_content,"${item.enter_type}")
        holder.setText(R.id.direction,"${item.direct}")
        holder.setText(R.id.money_price,"$${item.money_price}")
        holder.setText(R.id.out_price,"$${item.out_price}")
        holder.setText(R.id.price,"$${item.price}")
        holder.setText(R.id.time,"创建时间:${item.create_time.substring(0,16).replace("T"," ")}")
        holder.setText(R.id.weight_content,"${item.data_type}")

    }
}