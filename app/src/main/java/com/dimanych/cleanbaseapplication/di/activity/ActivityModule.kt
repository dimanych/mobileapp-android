package com.dimanych.cleanbaseapplication.di.activity

import com.dimanych.cleanbaseapplication.di.fragment.FragmentModule
import com.dimanych.cleanbaseapplication.di.fragment.FragmentScope
import com.dimanych.cleanbaseapplication.presentation.auth.login.LoginFragment
import com.dimanych.cleanbaseapplication.presentation.base.ErrorFragment
import com.dimanych.cleanbaseapplication.presentation.main.submain.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Dmitriy Grigoriev
 */
@Module
interface ActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FragmentModule::class)])
    fun errorFragment(): ErrorFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FragmentModule::class)])
    fun mainFragment(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FragmentModule::class)])
    fun loginFragment(): LoginFragment


}
