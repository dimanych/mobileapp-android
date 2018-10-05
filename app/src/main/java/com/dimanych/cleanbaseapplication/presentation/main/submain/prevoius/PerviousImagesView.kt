package com.dimanych.cleanbaseapplication.presentation.main.submain.prevoius

import com.dimanych.cleanbaseapplication.base.BaseView
import com.dimanych.cleanbaseapplication.data.main.model.ImageData

/**
 * @author Dmitrii Grigorev
 */
interface PerviousImagesView : BaseView {

    fun onPreviousLoaded(imageData: ImageData)

}