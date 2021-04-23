package com.example.module_home.fragment


import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.base.base.BaseVmFragment
import com.example.base.base.DataBindingConfig
import com.example.base.utils.toast
import com.example.common.common.setNoRepeatClick
import com.example.module_home.R
import com.example.module_home.BR
import com.example.module_home.vm.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : BaseVmFragment()  {

    private lateinit var loginVM: LoginViewModel

    override fun init(savedInstanceState: Bundle?) {
        initView()
    }

    override fun initView() {
        setNoRepeatClick(logins) {
            when (it.id) {
                //注册
//                R.id.tvRegister -> nav().navigate(R.id.action_main_fragment_to_register_fragment)
                //清除账号
//                R.id.ivClear -> {
//                    loginVM.username.set("")
//                }
                //密码是否可见
//                R.id.ivPasswordVisibility -> {
//                    //true false 切换
//                    loginVM.passIsVisibility.set(!loginVM.passIsVisibility.get()!!)
//                }
                //登陆
                R.id.logins -> {
                    //关闭软键盘
//                    KeyBoardUtil.closeKeyboard(etUsername,mActivity)
//                    KeyBoardUtil.closeKeyboard(etPassword,mActivity)
                    if (loginVM.username.get()!!.isEmpty()){
                        toast("请填写用户名")
                        return@setNoRepeatClick
                    }
                    if (loginVM.password.get()!!.isEmpty()){
                        toast("请填写密码")
                        return@setNoRepeatClick
                    }
                    login()
                }
                //跳过登陆
//                R.id.tvSkip -> {
//                    nav().navigateUp()
//                }
            }
        }
    }
    override fun initViewModel() {
        loginVM = getActivityViewModel(LoginViewModel::class.java)
    }

    override fun observe() {
        loginVM.loginLiveData.observe(this, Observer {
            toast("登陆成功")
        })
    }

    private fun login() {
        loginVM.login()
    }

    override fun getLayoutId(): Int? {
        return R.layout.fragment_login
    }

    override fun getDataBindingConfig(): DataBindingConfig? {
        return DataBindingConfig(R.layout.fragment_login, loginVM)
            .addBindingParam(BR.vm, loginVM)
    }


}