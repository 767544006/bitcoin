package com.example.btcoinwatch.app

import com.aleyn.mvvm.app.MVVMLin
import com.aleyn.mvvm.base.BaseApplication
import com.blankj.utilcode.util.LogUtils
import com.example.btcoinwatch.BuildConfig
import kotlinx.coroutines.CoroutineExceptionHandler

class App : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        MVVMLin.setNetException(CoroutineExceptionHandler { context, e ->
            LogUtils.e("NetWorkErr", e.message)
        })
        LogUtils.getConfig().run {
            isLogSwitch = BuildConfig.DEBUG
            setSingleTagSwitch(true)
        }
    }
}