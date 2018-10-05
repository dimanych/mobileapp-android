package com.dimanych.cleanbaseapplication.presentation.main.submain.prevoius

import com.dimanych.cleanbaseapplication.R
import com.dimanych.cleanbaseapplication.base.AbstractBaseFragment
import com.dimanych.cleanbaseapplication.data.main.model.ImageData
import com.dimanych.cleanbaseapplication.util.bind.Layout
import com.dimanych.cleanbaseapplication.util.extensions.load
import kotlinx.android.synthetic.main.fragment_previous_images.*

/**
 * @author Dmitrii Grigorev
 */
@Layout(R.layout.fragment_previous_images)
class PerviousImagesFragment : AbstractBaseFragment<PerviousImagesView, PerviousImagesPresenter>(), PerviousImagesView {

    override fun onPreviousLoaded(imageData: ImageData) {
        ivPrevious.load(imageData.imgSource)
    }
}