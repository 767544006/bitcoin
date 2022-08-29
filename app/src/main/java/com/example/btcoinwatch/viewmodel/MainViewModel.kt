package com.example.btcoinwatch.viewmodel

import com.aleyn.mvvm.base.BaseViewModel
import com.aleyn.mvvm.extend.asResponse
import com.aleyn.mvvm.extend.bindLoading
import com.example.btcoinwatch.net.TaskNetWork
import com.example.btcoinwatch.net.bean.Task
import kotlinx.coroutines.flow.MutableSharedFlow

class MainViewModel:BaseViewModel() {
    private val homeRepository by lazy { TaskNetWork.getInstance() }
    val mTask: MutableSharedFlow<List<Task>> = MutableSharedFlow()
    val mResult: MutableSharedFlow<String> = MutableSharedFlow()

    fun getTaskList(){
        launch {
            homeRepository.getTaskData()
                .asResponse()
                .bindLoading(this@MainViewModel)//绑定Lodaing
                .collect(mTask)
        }
    }
    fun insertTaskList(name:String,price:Float,desc:String,money:Float,stop:Float,enter_type:String,direct:String,url:String,data_type:String){
        launch {
            homeRepository.insertTaskData(name,price,desc,money,stop,enter_type, direct, url,data_type)
                .asResponse()
                .bindLoading(this@MainViewModel)//绑定Lodaing
                .collect(mResult)
        }

    }
}