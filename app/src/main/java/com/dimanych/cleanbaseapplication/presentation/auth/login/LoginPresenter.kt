package com.dimanych.cleanbaseapplication.presentation.auth.login

import com.dimanych.cleanbaseapplication.base.AbstractBasePresenter
import com.dimanych.cleanbaseapplication.domain.main.MainInteractor
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class LoginPresenter @Inject internal constructor(
        private val router: Router,
        private val interactor: MainInteractor
) : AbstractBasePresenter<LoginView>() {

    fun loadData() {
        subscribe(interactor.loadData(), {
            getView()?.onDataLoaded(it)
        })
    }


}
