package com.dimanych.cleanbaseapplication.data.main

import com.dimanych.cleanbaseapplication.data.main.model.ImageData
import dagger.Reusable
import io.reactivex.Single
import javax.inject.Inject

@Reusable
class MainHttpRepository @Inject constructor(private val mainApi: MainApi) {

    fun loadImages(): Single<List<ImageData>> {
        return mainApi.loadImagesList()
                .map { imageSources -> imageSources.map { ImageData(it) } }
    }
}