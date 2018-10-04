package com.dimanych.cleanbaseapplication.presentation.base

import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.dimanych.cleanbaseapplication.R
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import timber.log.Timber

abstract class AbstractFragmentNavigator constructor(
        val activity: AppCompatActivity
): SupportFragmentNavigator(activity.supportFragmentManager, R.id.flFragmentContainer) {


    override fun showSystemMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
        Timber.e(message)
    }

    override fun exit() {
        activity.finish()
    }

}