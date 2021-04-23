package com.example.base.base

import android.os.Bundle
import com.example.base.base.BaseVmFragment

/**
 * des 基于androidx 实现懒加载
 */
abstract class LazyVmFragment : BaseVmFragment(){

    private var isLoaded = false
    override fun onResume() {
        super.onResume()
        //增加了Fragment是否可见的判断
        if (!isLoaded && !isHidden) {
            lazyInit()
            isLoaded = true
        }
    }

    override fun init(savedInstanceState: Bundle?) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isLoaded = false
    }

    abstract fun lazyInit()

}