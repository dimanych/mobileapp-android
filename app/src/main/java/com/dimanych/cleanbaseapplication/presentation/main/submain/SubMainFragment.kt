package com.dimanych.cleanbaseapplication.presentation.main.submain

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.dimanych.cleanbaseapplication.R
import com.dimanych.cleanbaseapplication.base.AbstractBaseFragment
import com.dimanych.cleanbaseapplication.util.bind.Layout
import kotlinx.android.synthetic.main.fragment_sub_main.*

/**
 * @author Dmitrii Grigorev
 */
@Layout(R.layout.fragment_sub_main)
class SubMainFragment : AbstractBaseFragment<SubMainView, SubMainPresenter>(), SubMainView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pbLoading.visibility = VISIBLE
    }

    override fun onLoaded() {
        pbLoading.visibility = GONE
        val pagerAdapter = ImagesPagerAdapter(requireActivity().supportFragmentManager)
        vpPager.adapter = pagerAdapter
        tlTitle.setupWithViewPager(vpPager)

        vpPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(page: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(page: Int) {

            }
        })
    }
}
