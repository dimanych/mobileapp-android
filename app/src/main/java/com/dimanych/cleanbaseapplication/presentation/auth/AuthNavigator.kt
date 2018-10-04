package com.dimanych.cleanbaseapplication.presentation.auth

import android.support.v4.app.Fragment
import com.dimanych.cleanbaseapplication.di.activity.ActivityScope
import com.dimanych.cleanbaseapplication.presentation.auth.AuthActivity
import com.dimanych.cleanbaseapplication.presentation.auth.login.LoginFragment
import com.dimanych.cleanbaseapplication.presentation.base.AbstractFragmentNavigator
import com.dimanych.cleanbaseapplication.presentation.base.ErrorFragment
import com.dimanych.cleanbaseapplication.presentation.main.submain.MainFragment
import com.dimanych.cleanbaseapplication.util.Screens.LOGIN_SCREEN
import javax.inject.Inject

@ActivityScope
class AuthNavigator @Inject internal constructor(
        activity: AuthActivity
) : AbstractFragmentNavigator(activity) {

    override fun createFragment(screenKey: String, data: Any): Fragment? {
        return when (screenKey) {
            LOGIN_SCREEN -> LoginFragment()
            else -> ErrorFragment()
        }
    }


}
