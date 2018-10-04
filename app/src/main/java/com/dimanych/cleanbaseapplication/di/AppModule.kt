package com.dimanych.cleanbaseapplication.di

import com.dimanych.cleanbaseapplication.di.activity.ActivityModule
import com.dimanych.cleanbaseapplication.di.activity.ActivityScope
import com.dimanych.cleanbaseapplication.presentation.auth.AuthActivity
import com.dimanych.cleanbaseapplication.presentation.main.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = arrayOf(AndroidSupportInjectionModule::class))
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(ActivityModule::class)])
    fun mainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(ActivityModule::class)])
    fun authActivity(): AuthActivity

}
