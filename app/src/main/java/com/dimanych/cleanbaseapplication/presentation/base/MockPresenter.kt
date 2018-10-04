package com.dimanych.cleanbaseapplication.presentation.base

import com.dimanych.cleanbaseapplication.base.AbstractBasePresenter
import com.dimanych.cleanbaseapplication.base.BaseView
import com.dimanych.cleanbaseapplication.di.fragment.FragmentScope

import javax.inject.Inject

@FragmentScope
class MockPresenter @Inject
constructor() : AbstractBasePresenter<BaseView>()
