package com.example.btcoinwatch

import android.graphics.Color
import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import com.aleyn.mvvm.adapter.ViewPagerAdapter
import com.aleyn.mvvm.base.BaseActivity
import com.example.btcoinwatch.databinding.ActivityMainBinding
import com.example.btcoinwatch.ui.fragment.DataFragment
import com.example.btcoinwatch.ui.fragment.HomeFragment
import com.example.btcoinwatch.ui.fragment.MeFragment
import me.majiajie.pagerbottomtabstrip.NavigationController


class MainActivity : BaseActivity<ActivityMainBinding>(){
    private val fragments by lazy { mutableListOf<Fragment>(HomeFragment(),DataFragment(),MeFragment()) }
    private val adapter by lazy { ViewPagerAdapter(fragments,supportFragmentManager) }
    override fun initView(savedInstanceState: Bundle?) {
        mBinding.viewpager.adapter=adapter
        mBinding.viewpager.offscreenPageLimit=5
        val navigationController: NavigationController = mBinding.tab.material()
            .addItem(R.drawable.ic__home, "首页",resources.getColor(R.color.theme_color))
            .addItem(R.drawable.ic_data, "分析",resources.getColor(R.color.theme_color))
            .addItem(R.drawable.ic_me, "我的",resources.getColor(R.color.theme_color))
            .setDefaultColor(Color.parseColor("#707070"))
            .build()
        navigationController.setupWithViewPager(mBinding.viewpager);

    }

    override fun initData() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}