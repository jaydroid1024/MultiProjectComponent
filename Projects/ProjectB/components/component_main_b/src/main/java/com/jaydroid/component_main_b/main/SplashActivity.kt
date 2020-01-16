package com.jaydroid.component_main_b.main

import android.animation.Animator
import com.jaydroid.component_main_b.R
import com.jaydroid.conponent_base.arouter.ARouterHelper
import com.jaydroid.conponent_base.arouter.service.user.UserService
import com.jaydroid.conponent_base.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {


    override fun getLayoutResId(): Int {
        return R.layout.activity_splash
    }

    override fun initView() {
        lav_logo.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                gotoMainActivity()
            }
        })
    }

    private fun gotoMainActivity() {
        val userService = ARouterHelper.getService<UserService>(UserService::class.java)
        val user = userService?.getUserInfo()
        if (user != null && user.id > 0) {
            ARouterHelper.routerTo(ARouterHelper.Path.HOME_ACTIVITY_PATH)
        } else {
            ARouterHelper.routerTo(ARouterHelper.Path.LOGIN_ACTIVITY_PATH)
        }
        finish()
    }
}
