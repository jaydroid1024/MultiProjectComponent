package com.jaydroid.component_login_a.user.activity

import android.view.View
import android.widget.Button
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.jaydroid.component_lib.utils.SPUtils
import com.jaydroid.component_login_a.R
import com.jaydroid.component_login_a.user.contract.LoginGitHubContract
import com.jaydroid.component_login_a.user.presenter.LoginGitHubPresenter
import com.jaydroid.conponent_base.arouter.ARouterHelper
import com.jaydroid.conponent_base.base.mvp.BaseMVPActivity
import com.jaydroid.conponent_base.constant.Constants
import com.jaydroid.conponent_base.network.bean.github.BasicToken
import com.jaydroid.conponent_base.network.bean.github.GitUser
import com.jaydroid.conponent_base.widget.LoginView
import okhttp3.Credentials

@Route(path = ARouterHelper.Path.LOGIN_GITHUB_ACTIVITY_PATH)
class LoginGitHubActivity : BaseMVPActivity<LoginGitHubContract.View, LoginGitHubPresenter>(),
    LoginGitHubContract.View, View.OnClickListener {

    private lateinit var userNameEt: TextInputEditText
    private lateinit var userNameLayout: TextInputLayout
    private lateinit var passwordEt: TextInputEditText
    private lateinit var passwordLayout: TextInputLayout
    private lateinit var loginView: LoginView
    private lateinit var btnOauthLogin: Button

    private var userName: String? = null
    private var password: String? = null
    override fun getLayoutResId(): Int {
        return R.layout.component_login_a_activity_login
    }

    override fun createPresenter(): LoginGitHubPresenter {
        return LoginGitHubPresenter()
    }

    override fun initView() {
        userNameEt = findViewById(R.id.user_name_et)
        userNameLayout = findViewById(R.id.user_name_layout)
        passwordEt = findViewById(R.id.password_et)
        passwordLayout = findViewById(R.id.password_layout)
        loginView = findViewById(R.id.lv_login)
        btnOauthLogin = findViewById(R.id.oauth_login_bn)
        loginView.setOnClickListener(this)
        btnOauthLogin.setOnClickListener(this)

    }


    override fun initData() {
        super.initData()
        userNameEt.setText("Jay-Droid")
        passwordEt.setText("jie920824")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.lv_login -> {
                login()
            }
            R.id.oauth_login_bn -> {

            }
        }
    }

    private fun login() {
        userName = userNameEt.text!!.toString()
        password = passwordEt.text!!.toString()
        if (userName.isNullOrEmpty()) {
            userNameLayout.error = "Invalid username!"
            return
        } else {
            userNameLayout.isErrorEnabled = false
        }
        if (password.isNullOrBlank()) {
            passwordLayout.error = "Invalid password!"
            return
        } else {
            passwordLayout.isErrorEnabled = false
        }
        val authToken = Credentials.basic(userName!!, password!!)
        SPUtils.put(this, Constants.SP.AUTH_GITHUB_TOKEN, authToken)
        presenter.login(userName!!, password!!)

    }


    override fun showLoading() {
        loginView.setState(LoginView.STATE_LOADING)
    }

    override fun dismissLoading() {
        loginView.setState(LoginView.STATE_FAILED)
    }

    override fun onLoginResult(response: BasicToken) {
        SPUtils.put(this, Constants.SP.AUTH_GITHUB_TOKEN, response.token)
        presenter.getUserInfo()
    }

    override fun onLoginComplete(response: GitUser) {
        ARouterHelper.routerTo(ARouterHelper.Path.HOME_ACTIVITY_PATH)
        finish()
    }


    override fun onDestroy() {
        super.onDestroy()
    }

}
