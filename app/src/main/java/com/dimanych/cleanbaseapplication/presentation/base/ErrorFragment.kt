package com.dimanych.cleanbaseapplication.presentation.base

import com.dimanych.cleanbaseapplication.R
import com.dimanych.cleanbaseapplication.base.AbstractBaseFragment
import com.dimanych.cleanbaseapplication.base.BaseView
import com.dimanych.cleanbaseapplication.util.bind.Layout

@Layout(R.layout.fragment_error)
class ErrorFragment : AbstractBaseFragment<BaseView, MockPresenter>(), BaseView