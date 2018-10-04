package com.dimanych.cleanbaseapplication.data.main

import com.dimanych.cleanbaseapplication.data.main.model.ImageData
import com.dimanych.cleanbaseapplication.util.SharedPreferencesHelper
import dagger.Reusable
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

@Reusable
class MainLocalRepository @Inject constructor(
        private val preferencesHelper: SharedPreferencesHelper
) {

    //TODO temporally decision, NEED MIGRATE TO DATABASE
    fun saveImages(imagesDataList: List<ImageData>): Completable {
        return preferencesHelper.putImagesData(imagesDataList)
    }

    //TODO temporally decision, NEED MIGRATE TO DATABASE
    fun loadImages(): Single<List<ImageData>> {
        return preferencesHelper.getImagesList()
    }

}