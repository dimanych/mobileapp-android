package com.dimanych.cleanbaseapplication.presentation.main.submain.images

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.dimanych.cleanbaseapplication.R
import com.dimanych.cleanbaseapplication.base.AbstractBaseFragment
import com.dimanych.cleanbaseapplication.data.main.model.ImageData
import com.dimanych.cleanbaseapplication.util.bind.Layout
import kotlinx.android.synthetic.main.fragment_images.*
import javax.inject.Inject

/**
 * @author Dmitrii Grigorev
 */
@Layout(R.layout.fragment_images)
class ImagesFragment : AbstractBaseFragment<ImagesView, ImagesPresenter>(), ImagesView {

    @Inject
    lateinit var adapter: ImageAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvImages.adapter = adapter
        val layoutManager = LinearLayoutManager(context)
        rvImages.layoutManager = layoutManager
        rvImages.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
    }

    override fun onImagesLoaded(imageDataList: List<ImageData>) {
        adapter.setItems(imageDataList)
    }

    override fun onSelectedId(position: Int) {
        adapter.setChecked(position)
    }
}

