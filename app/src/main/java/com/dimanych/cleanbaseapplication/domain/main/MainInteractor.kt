package com.dimanych.cleanbaseapplication.domain.main

import com.dimanych.cleanbaseapplication.data.main.MainHttpRepository
import com.dimanych.cleanbaseapplication.data.main.MainLocalRepository
import com.dimanych.cleanbaseapplication.data.main.model.ImageData
import dagger.Reusable
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

@Reusable
class MainInteractor @Inject constructor(
        private val httpRepository: MainHttpRepository,
        private val localRepository: MainLocalRepository
) {

    fun loadImagesRemote(): Completable = httpRepository.loadImages()
            .flatMapCompletable { imagesDataList ->
                localRepository.saveImages(imagesDataList)
            }

    fun loadImagesLocal(): Single<List<ImageData>> = localRepository.loadImages()

}