package com.dimanych.cleanbaseapplication.presentation.main.submain.last

import com.dimanych.cleanbaseapplication.base.AbstractBasePresenter
import com.dimanych.cleanbaseapplication.domain.counter.CounterInteractor
import com.dimanych.cleanbaseapplication.domain.main.MainInteractor
import javax.inject.Inject

/**
 * @author Dmitrii Grigorev
 */
class LastImagesPresenter @Inject internal constructor(
        private val counterInteractor: CounterInteractor
) : AbstractBasePresenter<LastImagesView>() {

    override fun onFirstAttach() {
        subscribe(counterInteractor.observeLastSelected(),
                { getView()?.onLastImage(it) })
    }
}