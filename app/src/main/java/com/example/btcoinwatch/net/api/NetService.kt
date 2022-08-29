package com.example.btcoinwatch.net.api


import com.example.btcoinwatch.app.BaseResult
import com.example.btcoinwatch.net.bean.Task
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *   @author : Aleyn
 *   time   : 2019/10/29
 */
interface NetService {


    @GET("getTask")
    fun getTask(): Flow<BaseResult<List<Task>>>

    @GET("insertTask")
    fun insertTask(@Query("usdt") usdt: String,@Query("price") price: String,@Query("desc1") desc1: String,@Query("money_price") money: String="",@Query("out_price") stop: String="",@Query("enter_type") enter_type: String,@Query("direct") direct: String,@Query("url") url: String,@Query("data_type") data_type: String): Flow<BaseResult<String>>

}