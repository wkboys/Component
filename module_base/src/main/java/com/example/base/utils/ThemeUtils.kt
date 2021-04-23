package com.example.base.utils

import androidx.appcompat.app.AppCompatActivity
import com.example.base.R

object ThemeUtils {
    /**
     * 动态切换主题
     */
    fun changeTheme(activity: AppCompatActivity) {
        val theme = PrefUtils.getBoolean(Constants.SP_THEME_KEY,false)
        if (theme) {
            activity.setTheme(R.style.AppTheme_Night)
        } else {
            activity.setTheme(R.style.AppTheme)
        }
    }

    /**
     * 沉浸式状态,随主题改变
     */
    fun setSystemInvadeBlack(activity: AppCompatActivity) {
        StatusUtils.setUseStatusBarColor(activity, ColorUtils.parseColor("#00ffffff"))
        val theme = PrefUtils.getBoolean(Constants.SP_THEME_KEY,false)
        if (theme) {
            StatusUtils.setSystemStatus(activity, true, false)
        } else {
            StatusUtils.setSystemStatus(activity, true, true)
        }
    }
}