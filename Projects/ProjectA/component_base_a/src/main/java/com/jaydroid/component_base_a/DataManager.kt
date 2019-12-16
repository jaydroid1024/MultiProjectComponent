package com.jaydroid.component_base_a

import com.jaydroid.conponent_base.DataManager

/**
 * 数据管理类
 * @author wangxuejie
 * @date 2019-12-16 16:41
 * @version 1.0
 */
object DataManagerA : DataManager() {
    /**
     * 获取登录信息
     */
    override fun loginRequest(): String {
        return "Jay-ProjectA"
    }
}