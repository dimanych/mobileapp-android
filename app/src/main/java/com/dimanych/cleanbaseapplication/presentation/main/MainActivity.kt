package com.dimanych.cleanbaseapplication.presentation.main

import android.os.Bundle
import com.dimanych.cleanbaseapplication.R
import com.dimanych.cleanbaseapplication.base.AbstractBaseActivity
import com.dimanych.cleanbaseapplication.util.bind.Layout

@Layout(R.layout.activity_main)
class MainActivity : AbstractBaseActivity<MainView, MainPresenter, MainNavigator>(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.openMainScreen()
    }

}
