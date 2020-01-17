package com.jaydroid.component_base_a.github_net

import android.annotation.SuppressLint
import android.app.Application
import com.jaydroid.conponent_base.network.default_net.NetConfigHelper

/**
 *
 * @author wangxuejie
 * @date 2019-12-25 17:51
 * @version 1.0
 */
@SuppressLint("StaticFieldLeak")
object GitNetFactory {

    var gitHubNetwork: GitHubNetwork? = null

    /**
     * 获取应用类实例
     *
     * @return Application
     */
    lateinit var application: Application

    fun initialize(app: Application) {
        application = app
    }

    @Synchronized
    fun getGitHubNet(): GitHubNetwork {
        val configMap =
            NetConfigHelper.getNetConfigMap()
        configMap["base_url"] = "https://api.github.com"
        if (gitHubNetwork == null) {
            gitHubNetwork = GitHubNetwork(application.applicationContext!!, configMap)
        }
        gitHubNetwork?.configMap = configMap
        return gitHubNetwork!!
    }


}