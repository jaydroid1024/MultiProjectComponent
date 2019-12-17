package com.jaydroid.component_login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.jaydroid.conponent_base.DataManager
import com.jaydroid.conponent_base.arouter.ARouterHelper
import com.jaydroid.conponent_base.constant.Constants
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

@Route(path = ARouterHelper.Path.LOGIN_ACTIVITY_PATH)
class LoginActivity : AppCompatActivity() {

    /**
     * Intent传递的参数
     */
    private var mMapParams: HashMap<*, *>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initIntent()
        val idInfo = ARouterHelper.getParamsMapString(mMapParams, Constants.MapKey.ID)
        tv_from.text = idInfo

        tv_from.append("\n 登录人信息:" + DataManager.loginRequest())

    }

    private fun initIntent() {
        if (intent != null && intent.hasExtra(Constants.IntentKey.MAP_PARAMS)) {
            mMapParams =
                intent.getSerializableExtra(Constants.IntentKey.MAP_PARAMS) as? HashMap<*, *>?
        }

    }


}
