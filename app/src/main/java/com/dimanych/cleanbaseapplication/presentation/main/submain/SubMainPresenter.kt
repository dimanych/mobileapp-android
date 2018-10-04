package com.dimanych.cleanbaseapplication.presentation.main.submain

import com.dimanych.cleanbaseapplication.base.AbstractBasePresenter
import com.dimanych.cleanbaseapplication.di.activity.ActivityScope
import com.dimanych.cleanbaseapplication.domain.main.MainInteractor
import javax.inject.Inject

@ActivityScope
class SubMainPresenter @Inject internal constructor(
        private val interactor: MainInteractor
) : AbstractBasePresenter<SubMainView>() {

    override fun onFirstAttach() {
        subscribe(interactor.loadImagesRemote(), { getView()?.onLoaded() })
    }


}
