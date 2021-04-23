package com.example.module_home.activity

import android.os.Bundle
import com.example.common.common.clickNoRepeat
import com.example.base.utils.PrefUtils
import com.example.module_home.R
import com.example.base.base.BaseVmActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseVmActivity() {


    override fun init(savedInstanceState: Bundle?) {
        val theme = PrefUtils.getBoolean(Constants.SP_THEME_KEY,false)
        btn.clickNoRepeat {
            PrefUtils.setBoolean(Constants.SP_THEME_KEY, !theme)
            recreate()
        }

    }

    override fun getLayoutId(): Int? {
        return R.layout.activity_home
    }


}