package com.dimanych.cleanbaseapplication.presentation.main

import android.support.v4.app.Fragment
import com.dimanych.cleanbaseapplication.di.activity.ActivityScope
import com.dimanych.cleanbaseapplication.presentation.base.AbstractFragmentNavigator
import com.dimanych.cleanbaseapplication.presentation.base.ErrorFragment
import com.dimanych.cleanbaseapplication.presentation.main.submain.MainFragment
import com.dimanych.cleanbaseapplication.util.Screens.MAIN_SCREEN
import javax.inject.Inject

@ActivityScope
class MainNavigator @Inject internal constructor(
        activity: MainActivity
) : AbstractFragmentNavigator(activity) {

    override fun createFragment(screenKey: String, data: Any): Fragment? {
        return when (screenKey) {
            MAIN_SCREEN -> MainFragment()
            else -> ErrorFragment()
        }
    }


}
