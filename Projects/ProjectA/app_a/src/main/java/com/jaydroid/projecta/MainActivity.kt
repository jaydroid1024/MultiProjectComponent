package com.jaydroid.projecta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.jaydroid.component_base_a.arouter.ARouterPathForA
import com.jaydroid.conponent_base.arouter.ARouterHelper
import com.jaydroid.conponent_base.constant.Constants
import kotlinx.android.synthetic.main.activity_main.*

/**
 * ARouter:path必须以'/'开头，并且包含多于2 '/'的内容!
 * ARouter:默认会用你R申明的path的第一个/后面的字符用作group，不同组件之间的group不能相同
 */
@Route(path = ARouterHelper.Path.HOME_ACTIVITY_PATH)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_login.setOnClickListener {
            val map = ARouterHelper.getParamsMap(1)
            map[Constants.MapKey.ID] = "数据来自：ProjectA-MainActivity"
            ARouterHelper.routerTo(map, ARouterHelper.Path.LOGIN_ACTIVITY_PATH)
        }

        tv_detail.setOnClickListener {
            val map = ARouterHelper.getParamsMap(1)
            map[Constants.MapKey.ID] = "数据来自：ProjectA-MainActivity"
            ARouterHelper.routerTo(map, ARouterPathForA.DETAIL_ACTIVITY_PATH)
        }
    }
}
