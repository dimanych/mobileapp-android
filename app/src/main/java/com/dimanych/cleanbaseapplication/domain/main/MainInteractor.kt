package com.dimanych.cleanbaseapplication.domain.main

import com.dimanych.cleanbaseapplication.data.main.MainHttpRepository
import com.dimanych.cleanbaseapplication.data.main.model.ImageData
import dagger.Reusable
import io.reactivex.Single
import javax.inject.Inject

@Reusable
class MainInteractor @Inject constructor(
        val httpRepository: MainHttpRepository
) {

    fun loadImages(): Single<List<ImageData>> = httpRepository.loadImages()

}