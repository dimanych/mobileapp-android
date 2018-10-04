package com.dimanych.cleanbaseapplication.presentation.auth.login

import android.os.Bundle
import android.view.View
import com.dimanych.cleanbaseapplication.R
import com.dimanych.cleanbaseapplication.base.AbstractBaseFragment
import com.dimanych.cleanbaseapplication.util.bind.Layout
import com.dimanych.cleanbaseapplication.util.extensions.string
import kotlinx.android.synthetic.main.fragment_login.*
import timber.log.Timber

@Layout(R.layout.fragment_login)
class LoginFragment : AbstractBaseFragment<LoginView, LoginPresenter>(), LoginView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener { presenter.auth(etLogin.string(), etPassword.string()) }
    }

    override fun onAuthSuccess() {
        Timber.d("Enter success")
    }

}
