package com.dimanych.cleanbaseapplication.base

import ru.terrakok.cicerone.Router

/**
 * For cicerone 3.0.0 method navigateTo throw exception for null values
 */
class HackRouter : Router() {

    override fun navigateTo(screenKey: String?) {
        super.navigateTo(screenKey, "")
    }
}