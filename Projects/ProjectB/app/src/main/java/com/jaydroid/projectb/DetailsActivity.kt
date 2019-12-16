package com.jaydroid.projectb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_details.*

@Route(path = "/app_b/path/detail/activity")
class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        tv_from.text = intent.getStringExtra("from")

    }
}