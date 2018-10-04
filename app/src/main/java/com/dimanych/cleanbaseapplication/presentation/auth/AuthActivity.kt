package com.dimanych.cleanbaseapplication.presentation.auth

import android.os.Bundle
import com.dimanych.cleanbaseapplication.R
import com.dimanych.cleanbaseapplication.base.AbstractBaseActivity
import com.dimanych.cleanbaseapplication.base.BaseView
import com.dimanych.cleanbaseapplication.util.bind.Layout

@Layout(R.layout.activity_auth)
class AuthActivity : AbstractBaseActivity<BaseView, AuthPresenter, AuthNavigator>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.openLoginScreen()
    }
}
