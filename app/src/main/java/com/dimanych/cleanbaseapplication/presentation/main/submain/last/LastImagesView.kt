package com.dimanych.cleanbaseapplication.presentation.main.submain.last

import com.dimanych.cleanbaseapplication.base.BaseView
import com.dimanych.cleanbaseapplication.data.main.model.ImageData

/**
 * @author Dmitrii Grigorev
 */
interface LastImagesView : BaseView {

    fun onLastImage(imageData: ImageData)

}