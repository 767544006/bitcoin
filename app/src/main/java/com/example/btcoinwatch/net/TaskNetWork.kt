package com.example.btcoinwatch.net

import com.example.btcoinwatch.net.api.NetService

class TaskNetWork {

    private val mService by lazy { RetrofitClient.getInstance().create(NetService::class.java) }

    fun getTaskData() = mService.getTask()
    fun insertTaskData(name: String, price: Float, desc: String,money:Float,stop:Float,enter_type:String,direct:String,url:String,data_type:String) =
        mService.insertTask(name, price.toString(), desc,money.toString(),stop.toString(),enter_type,direct,url,data_type)


    companion object {
        @Volatile
        private var netWork: TaskNetWork? = null
        fun getInstance() = netWork ?: synchronized(this) {
            netWork ?: TaskNetWork().also { netWork = it }
        }
    }


}