package com.jaydroid.projecta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jaydroid.component_base_a.arouter.ARouterPathForA
import com.jaydroid.conponent_base.arouter.ARouterHelper
import com.jaydroid.conponent_base.arouter.service.user.GitHubUserService
import com.jaydroid.conponent_base.constant.Constants
import kotlinx.android.synthetic.main.activity_main.*


/**
 * ARouter:path必须以'/'开头，并且包含多于2 '/'的内容!
 * ARouter:默认会用你R申明的path的第一个/后面的字符用作group，不同组件之间的group不能相同
 */
@Route(path = ARouterHelper.Path.HOME_ACTIVITY_PATH)
class MainActivity : AppCompatActivity() {

    var loginRouterService: GitHubUserService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginRouterService =
            ARouter.getInstance().build(ARouterHelper.Path.GIT_LOGIN_SERVICE_PATH).navigation() as? GitHubUserService
        tv_login.append("\n通过服务获取的登录信息为：${loginRouterService?.getUserInfo()}")

        tv_login.setOnClickListener {
            val map = ARouterHelper.getParamsMap(1)
            map[Constants.MapKey.ID] = "数据来自：ProjectA-MainActivity"
            ARouterHelper.routerTo(map, ARouterHelper.Path.LOGIN_GITHUB_ACTIVITY_PATH)
        }

        tv_detail.setOnClickListener {
            val map = ARouterHelper.getParamsMap(1)
            map[Constants.MapKey.ID] = "数据来自：ProjectA-MainActivity"
            ARouterHelper.routerTo(map, ARouterPathForA.DETAIL_ACTIVITY_PATH)
        }
    }
}
