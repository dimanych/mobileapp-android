package com.dimanych.cleanbaseapplication.presentation.main

import com.dimanych.cleanbaseapplication.base.AbstractBasePresenter
import com.dimanych.cleanbaseapplication.di.activity.ActivityScope
import com.dimanych.cleanbaseapplication.domain.main.MainInteractor
import com.dimanych.cleanbaseapplication.util.Screens.LOGIN_SCREEN
import com.dimanych.cleanbaseapplication.util.Screens.MAIN_SCREEN
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@ActivityScope
class MainPresenter @Inject constructor(
        private val router: Router,
        private val interactor: MainInteractor
) : AbstractBasePresenter<MainView>() {

    fun openMainScreen() = router.navigateTo(LOGIN_SCREEN)

}
