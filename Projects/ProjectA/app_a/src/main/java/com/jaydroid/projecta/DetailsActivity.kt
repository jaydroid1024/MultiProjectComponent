package com.jaydroid.projecta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.jaydroid.component_base_a.arouter.ARouterPathForA
import com.jaydroid.conponent_base.arouter.ARouterHelper
import com.jaydroid.conponent_base.constant.Constants
import kotlinx.android.synthetic.main.activity_details.*
import java.util.*

@Route(path = ARouterPathForA.DETAIL_ACTIVITY_PATH)
class DetailsActivity : AppCompatActivity() {
    /**
     * Intent传递的参数
     */
    private var mMapParams: HashMap<*, *>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initIntent()
        val idInfo = ARouterHelper.getParamsMapString(mMapParams, Constants.MapKey.ID)
        tv_from.text = idInfo

    }

    private fun initIntent() {
        if (intent != null && intent.hasExtra(Constants.IntentKey.MAP_PARAMS)) {
            mMapParams =
                    intent.getSerializableExtra(Constants.IntentKey.MAP_PARAMS) as? HashMap<*, *>?
        }

    }

}
