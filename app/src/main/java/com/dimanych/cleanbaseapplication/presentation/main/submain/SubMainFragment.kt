package com.dimanych.cleanbaseapplication.presentation.main.submain

import android.os.Bundle
import android.view.View
import com.dimanych.cleanbaseapplication.R
import com.dimanych.cleanbaseapplication.base.AbstractBaseFragment
import com.dimanych.cleanbaseapplication.data.main.model.ImageData
import com.dimanych.cleanbaseapplication.util.bind.Layout
import kotlinx.android.synthetic.main.fragment_sub_main.*

/**
 * @author Dmitrii Grigorev
 */
@Layout(R.layout.fragment_sub_main)
class SubMainFragment : AbstractBaseFragment<SubMainView, SubMainPresenter>(), SubMainView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pagerAdapter = ImagesPagerAdapter(requireActivity().supportFragmentManager)
        vpPager.adapter = pagerAdapter
        tlTitle.setupWithViewPager(vpPager)
    }

    override fun onImagesLoaded(imageDataList: List<ImageData>) {

    }
}
