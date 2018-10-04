package com.dimanych.cleanbaseapplication.presentation.main.submain

import com.dimanych.cleanbaseapplication.base.BaseView
import com.dimanych.cleanbaseapplication.data.main.model.ImageData

interface SubMainView : BaseView {

    /**
     * runs when we loaded images from local database or API
     */
    fun onImagesLoaded(imageDataList: List<ImageData>)

}
