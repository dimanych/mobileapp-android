package com.dimanych.cleanbaseapplication.base

/**
 * @author Dmitriy Grigoriev
 */
interface BasePresenter<in T : BaseView> {

    fun takeView(t: T)

    fun detachFromView()
}
