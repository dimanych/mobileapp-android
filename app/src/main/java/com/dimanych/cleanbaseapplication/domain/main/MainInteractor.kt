package com.dimanych.cleanbaseapplication.domain.main

import com.dimanych.cleanbaseapplication.data.main.MainRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainInteractor @Inject constructor(
        val apiRepository: MainRepository
) {

    fun loadData(): Single<String> = apiRepository.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}