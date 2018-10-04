package com.dimanych.cleanbaseapplication.presentation.auth

import com.dimanych.cleanbaseapplication.base.AbstractBasePresenter
import com.dimanych.cleanbaseapplication.base.BaseView
import com.dimanych.cleanbaseapplication.di.activity.ActivityScope
import com.dimanych.cleanbaseapplication.util.Screens.LOGIN_SCREEN
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@ActivityScope
class AuthPresenter @Inject constructor(
        private val router: Router
) : AbstractBasePresenter<BaseView>() {

    fun openLoginScreen() = router.navigateTo(LOGIN_SCREEN)

}