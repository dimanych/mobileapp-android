package com.dimanych.cleanbaseapplication.presentation.main.submain.images

import com.dimanych.cleanbaseapplication.base.AbstractBasePresenter
import com.dimanych.cleanbaseapplication.domain.counter.CounterInteractor
import com.dimanych.cleanbaseapplication.domain.main.MainInteractor
import javax.inject.Inject

/**
 * @author Dmitrii Grigorev
 */
class ImagesPresenter @Inject internal constructor(
        private val mainInteractor: MainInteractor,
        private val counterInteractor: CounterInteractor
) : AbstractBasePresenter<ImagesView>() {

    override fun onFirstAttach() {
        subscribe(mainInteractor.loadImagesLocal()
                .doOnSuccess { getView()?.onImagesLoaded(it) }
                .map { counterInteractor.getLastSelectedId() },
                {
                    getView()?.onSelectedId(it)
                })
    }
}