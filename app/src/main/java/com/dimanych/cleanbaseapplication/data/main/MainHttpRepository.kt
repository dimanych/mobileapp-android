package com.dimanych.cleanbaseapplication.data.main

import io.reactivex.Single
import javax.inject.Inject

class MainHttpRepository @Inject constructor() : MainRepository {

    override fun getData(): Single<String> {
        return Single.just("data")
    }
}