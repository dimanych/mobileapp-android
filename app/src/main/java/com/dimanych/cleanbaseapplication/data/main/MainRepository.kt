package com.dimanych.cleanbaseapplication.data.main

import io.reactivex.Single

interface MainRepository {

    fun getData(): Single<String>

}