package com.example.btcoinwatch.ui.fragment

import android.os.Bundle
import com.aleyn.mvvm.base.BaseVMFragment
import com.aleyn.mvvm.base.NoViewModel
import com.example.btcoinwatch.databinding.FragmentDataBinding

class DataFragment: BaseVMFragment<NoViewModel,FragmentDataBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
    }
    override fun lazyLoadData() {
        super.lazyLoadData()
    }
}