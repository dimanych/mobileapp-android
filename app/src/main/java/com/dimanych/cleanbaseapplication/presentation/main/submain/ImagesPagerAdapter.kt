package com.dimanych.cleanbaseapplication.presentation.main.submain

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.dimanych.cleanbaseapplication.presentation.main.submain.images.ImagesFragment
import com.dimanych.cleanbaseapplication.presentation.main.submain.last.LastImagesFragment
import com.dimanych.cleanbaseapplication.presentation.main.submain.prevoius.PerviousImagesFragment

/**
 * @author Dmitrii Grigorev
 */
class ImagesPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    val pages = listOf("Images", "Last Selected Image", "Previous Selected Image")

    override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> ImagesFragment()
                1 -> LastImagesFragment()
                2 -> PerviousImagesFragment()
                else -> throw IllegalArgumentException("$position screen not found")
            }

    override fun getCount(): Int = pages.size

    override fun getPageTitle(position: Int): CharSequence = pages[position]
}