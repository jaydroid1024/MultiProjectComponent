package com.jaydroid.projectb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * ARouter:path必须以'/'开头，并且包含多于2 '/'的内容!
 * Arouter:默认会用你申明的path的第一个/后面的字符用作group，不同组件之间的group不能相同
 */
@Route(path = "/app_b/path/home/activity")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_login.setOnClickListener {
            ARouter.getInstance()
                .build("/component_login/path/login/activity")
                .withString("from", "来自：ProjectB-MainActivity")
                .navigation()

        }

        tv_detail.setOnClickListener {
            ARouter.getInstance()
                .build("/app_b/path/detail/activity")
                .withString("from", "来自：ProjectB-MainActivity")
                .navigation()
        }
    }
}
