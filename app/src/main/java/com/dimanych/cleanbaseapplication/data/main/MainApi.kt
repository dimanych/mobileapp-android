package com.dimanych.cleanbaseapplication.data.main

import io.reactivex.Single
import retrofit2.http.GET

interface MainApi {

    @GET("test/images")
    fun loadImagesList(): Single<List<String>>

}