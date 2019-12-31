package com.jaydroid.component_main_b.main

import android.animation.Animator
import com.airbnb.lottie.LottieAnimationView
import com.jaydroid.component_main_b.R
import com.jaydroid.conponent_base.arouter.ARouterHelper
import com.jaydroid.conponent_base.base.BaseActivity

class SplashActivity : BaseActivity() {

    private lateinit var logoLottieView: LottieAnimationView

    override fun getLayoutResId(): Int {
        return R.layout.activity_splash
    }

    override fun initView() {
        logoLottieView = findViewById(R.id.lav_logo)
        logoLottieView.addAnimatorListener(object : Animator.AnimatorListener {
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
        ARouterHelper.routerTo(ARouterHelper.Path.HOME_ACTIVITY_PATH)
        finish()
    }
}
