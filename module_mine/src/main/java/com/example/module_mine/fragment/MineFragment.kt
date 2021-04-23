package com.example.module_mine.fragment

import android.os.Bundle
import com.example.base.base.BaseVmFragment
import com.example.base.base.DataBindingConfig
import com.example.module_mine.R

class MineFragment : BaseVmFragment()  {


    override fun init(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int? {
        return R.layout.fragment_mine
    }

    override fun getDataBindingConfig(): DataBindingConfig? {
        return null
    }


}