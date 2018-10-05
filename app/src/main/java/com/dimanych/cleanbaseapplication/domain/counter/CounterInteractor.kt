package com.dimanych.cleanbaseapplication.domain.counter

import com.dimanych.cleanbaseapplication.data.counter.CounterRepository
import com.dimanych.cleanbaseapplication.data.main.MainLocalRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class CounterInteractor @Inject constructor(
        private val counterRepository: CounterRepository,
        private val mainLocalRepository: MainLocalRepository
) {

    fun getLastSelectedId() = counterRepository.getLastSelectedId()

    fun observeLastSelected() = counterRepository.getLastSelected()
            .flatMapSingle { mainLocalRepository.loadImage(it) }

    fun observePreviousSelected() = counterRepository.getPreviousSelected()
            .flatMap { mainLocalRepository.loadImage(it) }

    fun notifySelectedChanged(position: Int) = counterRepository.changePosition(position)

}