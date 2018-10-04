package com.dimanych.cleanbaseapplication.util.bind

import android.support.annotation.LayoutRes
import kotlin.annotation.AnnotationRetention.RUNTIME

@Retention(RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
annotation class Layout(@LayoutRes val value: Int)
