package com.example.btcoinwatch.ui.fragment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.aleyn.mvvm.base.BaseVMFragment
import com.blankj.utilcode.util.ToastUtils
import com.donkingliang.labels.LabelsView
import com.example.btcoinwatch.R
import com.example.btcoinwatch.adapter.TaskAdapter
import com.example.btcoinwatch.databinding.FragmentHomeBinding
import com.example.btcoinwatch.viewmodel.MainViewModel

class HomeFragment : BaseVMFragment<MainViewModel, FragmentHomeBinding>() {
    private val adapter by lazy { TaskAdapter() }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        adapter.data = mutableListOf()
        mBinding.recycle.adapter = adapter
        adapter.setEmptyView(R.layout.layout_empty)
        mBinding.floatButton.setOnClickListener {
            buildDialog()
        }
    }


    override fun lazyLoadData() {
        super.lazyLoadData()
        lifecycleScope.launchWhenCreated {
            viewModel.mTask.collect {
                adapter.data.clear()
                adapter.addData(it)
            }
        }
        lifecycleScope.launchWhenCreated {
            viewModel.mResult.collect {
                viewModel.getTaskList()
            }
        }
        viewModel.getTaskList()
    }

    private fun buildDialog() {
        MaterialDialog(requireContext())
            .cancelable(true)
            .customView(R.layout.dialog_create, noVerticalPadding = true)
            .lifecycleOwner(this)
            .cornerRadius(8f)
            .apply {
                val usdt = findViewById<EditText>(R.id.usdt)
                val price = findViewById<EditText>(R.id.price)
                val money = findViewById<EditText>(R.id.money_price)
                val stop = findViewById<EditText>(R.id.stop_price)
                val type = findViewById<LabelsView>(R.id.labels)
                val direction = findViewById<LabelsView>(R.id.direction_labs)
                val time = findViewById<LabelsView>(R.id.time_labs)
                time.setLabels(mutableListOf("30???", "1??????", "4??????", "??????"))
                direction.setLabels(mutableListOf("??????", "??????"))
                type.setLabels(mutableListOf("??????", "??????", "??????", "??????"))
                findViewById<Button>(R.id.ok).setOnClickListener {
                    if (usdt.text.isBlank()) {
                        ToastUtils.showLong("???????????????")
                        return@setOnClickListener
                    }
                    if (price.text.isBlank()) {
                        ToastUtils.showLong("???????????????")
                        return@setOnClickListener
                    }
                    if (stop.text.isBlank()) {
                        ToastUtils.showLong("???????????????")
                        return@setOnClickListener
                    }
                    if (money.text.isBlank()) {
                        money.setText("0")
                    }
                    if (type.selectLabels.size == 0) {
                        ToastUtils.showLong("?????????????????????")
                        return@setOnClickListener
                    }
                    if (direction.selectLabels.size == 0) {
                        ToastUtils.showLong("?????????????????????")
                        return@setOnClickListener
                    }
                    if (time.selectLabels.size == 0) {
                        ToastUtils.showLong("?????????????????????")
                        return@setOnClickListener
                    }
                    viewModel.insertTaskList(
                        usdt.text.toString(),
                        price.text.toString().toFloat(),
                        "",
                        money.text.toString().toFloat(),
                        stop.text.toString().toFloat(),
                        type.getSelectLabelDatas<String>()[0],
                        direction.getSelectLabelDatas<String>()[0],
                        "",
                        time.getSelectLabelDatas<String>()[0],

                        )
                    dismiss()
                }
            }
            .show()
    }


}