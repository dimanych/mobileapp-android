package com.dimanych.cleanbaseapplication.data.counter

import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CounterRepository @Inject constructor() {

    var lastSelected = -1
    var previousSelected = -1
    val lastSelectedPublisher = PublishSubject.create<Int>()

    fun getLastSelectedId() = lastSelected

    fun getLastSelected() = lastSelectedPublisher

    fun getPreviousSelected() = Single.just(previousSelected)

    fun changePosition(position: Int) {
        previousSelected = lastSelected
        lastSelected = position
        lastSelectedPublisher.onNext(position)
    }

}