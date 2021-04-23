package com.example.base.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.base.ApiException

/**
 * des 基础vm
 */

open class BaseViewModel:ViewModel() {

    /**
     * 错误信息liveData
     */
    val errorLiveData = MutableLiveData<ApiException>()

    /**
     * 无更多数据
     */
    val footLiveDate = MutableLiveData<Any>()

    /**
     * 无数据
     */
    val emptyLiveDate = MutableLiveData<Any>()
}