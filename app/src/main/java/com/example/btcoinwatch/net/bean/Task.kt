package com.example.btcoinwatch.net.bean



data class Task(
    val create_time: String,
    val desc1: String,
    val direct: String,
    val enter_type: String,
    val id: Int,
    val money_price: Double,
    val out_price: Double,
    val price: Double,
    val url: String?,
    val usdt: String?,
    val data_type:String
)