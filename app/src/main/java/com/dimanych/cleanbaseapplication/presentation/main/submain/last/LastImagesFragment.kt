package com.dimanych.cleanbaseapplication.presentation.main.submain.last

import com.dimanych.cleanbaseapplication.R
import com.dimanych.cleanbaseapplication.base.AbstractBaseFragment
import com.dimanych.cleanbaseapplication.data.main.model.ImageData
import com.dimanych.cleanbaseapplication.util.bind.Layout
import com.dimanych.cleanbaseapplication.util.extensions.load
import kotlinx.android.synthetic.main.fragment_last_images.*

/**
 * @author Dmitrii Grigorev
 */
@Layout(R.layout.fragment_last_images)
class LastImagesFragment : AbstractBaseFragment<LastImagesView, LastImagesPresenter>(), LastImagesView {

    override fun onLastImage(imageData: ImageData) {
        ivLast.load(imageData.imgSource)
    }
}