package com.dimanych.cleanbaseapplication.presentation.main.submain.images

import com.dimanych.cleanbaseapplication.base.BaseView
import com.dimanych.cleanbaseapplication.data.main.model.ImageData

/**
 * @author Dmitrii Grigorev
 */
interface ImagesView : BaseView {

    /**
     * runs when we loaded images from local database or API
     */
    fun onImagesLoaded(imageDataList: List<ImageData>)

}