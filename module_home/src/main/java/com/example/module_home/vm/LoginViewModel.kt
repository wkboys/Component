package com.example.module_home.vm

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.base.base.BaseViewModel
import com.example.network.constants.home.LoginRepo
import com.example.network.constants.bean.UserBean

class LoginViewModel : BaseViewModel() {
    /**
     * 用户名
     */
    val username = ObservableField<String>().apply {
        set("")
    }

    /**
     * 密码
     */
    val password = ObservableField<String>().apply {
        set("")
    }

    /**
     * 密码是否可见
     */
    val passIsVisibility = ObservableField<Boolean>().apply {
        set(false)
    }

    /**
     * 登陆
     */
    val loginLiveData = MutableLiveData<UserBean>()

    private val repo by lazy { LoginRepo(viewModelScope,errorLiveData) }

    fun login(){
        repo.login(username.get()!!,password.get()!!,loginLiveData)
    }
}