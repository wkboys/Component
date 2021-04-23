package com.example.network.constants.home

import androidx.lifecycle.MutableLiveData
import com.example.base.ApiException
import com.example.base.base.BaseRepository
import com.example.network.constants.ApiService
import com.example.network.constants.RetrofitManager
import com.example.base.utils.toast
import com.example.network.constants.bean.UserBean
import kotlinx.coroutines.CoroutineScope

/**
 * des 登陆
 */
class LoginRepo(coroutineScope: CoroutineScope, errorLiveData: MutableLiveData<ApiException>) :
    BaseRepository(coroutineScope, errorLiveData) {

    fun login(username: String, password: String,loginLiveData : MutableLiveData<UserBean>) {
//        val value: UserBean = UserBean ()
        launch(
            block = {
                RetrofitManager.getApiService(ApiService::class.java)
                    .login(username,password)
                    .data()
//                value
            },
            success = {
                //登陆成功保存用户信息，并发送消息
//                PrefUtils.setObject(Constants.USER_INFO,it)
                //更改登陆轧辊台
//                PrefUtils.setBoolean(Constants.LOGIN,true)
                //发送登陆消息
//                EventBus.getDefault().post(LoginEvent())
                loginLiveData.postValue(it)
            },
            error = {
                toast("登录失败啊啊啊啊")
            }
        )
    }

}