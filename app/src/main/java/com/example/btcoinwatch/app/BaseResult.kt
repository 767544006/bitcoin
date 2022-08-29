package com.example.btcoinwatch.app

import com.aleyn.mvvm.base.IBaseResponse

data class BaseResult<T>(
    val message: String,
    val code: Int,
    val data: T
) : IBaseResponse<T> {

    override fun code() = code

    override fun msg() = message

    override fun data() = data

    override fun isSuccess() = code == 200

}