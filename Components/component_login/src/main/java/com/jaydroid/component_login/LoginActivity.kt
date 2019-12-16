package com.jaydroid.component_login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.jaydroid.component_base_a.DataManagerA
import com.jaydroid.conponent_base.DataManager
import kotlinx.android.synthetic.main.activity_login.*

@Route(path = "/component_login/path/login/activity")
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tv_from.text = intent.getStringExtra("from")

        tv_from.append("\n 登录人信息:" + DataManager().loginRequest())

    }
}
