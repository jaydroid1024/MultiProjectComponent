package com.jaydroid.component_main_a.activity

import android.graphics.Color
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.bumptech.glide.Glide
import com.jaydroid.component_main_a.R
import com.jaydroid.component_main_a.contract.GitMainContract
import com.jaydroid.component_main_a.presenter.GitMainPresenter
import com.jaydroid.conponent_base.arouter.ARouterHelper
import com.jaydroid.conponent_base.base.mvp.BaseMVPActivity
import com.jaydroid.conponent_base.network.bean.github.GitUser

@Route(path = ARouterHelper.Path.GIT_MAIN_ACTIVITY_PATH)
class GitMainActivity : BaseMVPActivity<GitMainContract.View, GitMainPresenter>(),
    GitMainContract.View, View.OnClickListener {

    lateinit var userImageViewBg: ImageView
    lateinit var userImageView: ImageView
    lateinit var loader: ProgressBar
    lateinit var joinedTime: TextView
    lateinit var location: TextView
    lateinit var userName: TextView
    lateinit var tvInfo: TextView

    override fun getLayoutResId(): Int {
        return R.layout.component_main_a_activity_git_main
    }

    override fun createPresenter(): GitMainPresenter {
        return GitMainPresenter()
    }

    override fun initView() {
        setTransparentStatusBar()
        userImageViewBg = findViewById(R.id.user_avatar_bg)
        userImageView = findViewById(R.id.user_avatar)
        loader = findViewById(R.id.loader)
        joinedTime = findViewById(R.id.joined_time)
        location = findViewById(R.id.location)
        userName = findViewById(R.id.user_name)
        tvInfo = findViewById(R.id.tv_info)
    }

    fun setTransparentStatusBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            decorView.systemUiVisibility = option
            window.statusBarColor = Color.TRANSPARENT
        }
    }


    override fun initData() {
        super.initData()
        presenter.getUserInfo()
        showLoading()

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.user_avatar -> {

            }
        }
    }


    override fun showLoading() {
        loader.visibility = View.VISIBLE
    }

    override fun dismissLoading() {
        loader.visibility = View.GONE
    }


    override fun onLoginComplete(response: GitUser) {
        joinedTime.text = response.company
        location.text = response.location
        userName.text = response.login
        tvInfo.text = response.toString()
        Glide.with(this)
            .load(response.avatarUrl)
            .into(userImageViewBg)
        Glide.with(this)
            .load(response.avatarUrl)
            .into(userImageView)
    }


    override fun onDestroy() {
        super.onDestroy()
    }

}
