package com.dimanych.cleanbaseapplication.presentation.main.submain.prevoius

import com.dimanych.cleanbaseapplication.base.AbstractBasePresenter
import com.dimanych.cleanbaseapplication.domain.counter.CounterInteractor
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Dmitrii Grigorev
 */
class PerviousImagesPresenter @Inject internal constructor(
        private val counterInteractor: CounterInteractor
) : AbstractBasePresenter<PerviousImagesView>() {

    override fun onFirstAttach() {
        subscribe(counterInteractor.observePreviousSelected(),
                { getView()?.onPreviousLoaded(it) })
    }

}