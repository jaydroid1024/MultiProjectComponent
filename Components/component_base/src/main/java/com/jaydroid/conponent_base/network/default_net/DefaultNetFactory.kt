package com.jaydroid.conponent_base.network.default_net

import android.annotation.SuppressLint
import android.app.Application
import com.jaydroid.conponent_base.network.github_net.GitHubNetwork

/**
 *
 * @author wangxuejie
 * @date 2019-12-25 17:51
 * @version 1.0
 */
@SuppressLint("StaticFieldLeak")
object DefaultNetFactory {

    var defaultNetwork: DefaultNetwork? = null

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
    fun getDefaultNet(): DefaultNetwork {
        if (defaultNetwork == null) {
            defaultNetwork = DefaultNetwork(application.applicationContext!!)
        }
        return defaultNetwork!!
    }

    @Synchronized
    fun getGitHubNet(): GitHubNetwork {
        val configMap = NetConfigHelper.getNetConfigMap()
        configMap["base_url"] = "https://api.github.com"
        if (gitHubNetwork == null) {
            gitHubNetwork = GitHubNetwork(application.applicationContext!!, configMap)
        }
        gitHubNetwork?.configMap = configMap
        return gitHubNetwork!!
    }


}