package com.dimanych.cleanbaseapplication.di.activity

import com.dimanych.cleanbaseapplication.di.fragment.FragmentModule
import com.dimanych.cleanbaseapplication.di.fragment.FragmentScope
import com.dimanych.cleanbaseapplication.presentation.auth.login.LoginFragment
import com.dimanych.cleanbaseapplication.presentation.base.ErrorFragment
import com.dimanych.cleanbaseapplication.presentation.main.submain.SubMainFragment
import com.dimanych.cleanbaseapplication.presentation.main.submain.images.ImagesFragment
import com.dimanych.cleanbaseapplication.presentation.main.submain.last.LastImagesFragment
import com.dimanych.cleanbaseapplication.presentation.main.submain.prevoius.PerviousImagesFragment
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
    fun mainFragment(): SubMainFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FragmentModule::class)])
    fun loginFragment(): LoginFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FragmentModule::class)])
    fun imagesFragment(): ImagesFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FragmentModule::class)])
    fun lastImagesFragment(): LastImagesFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FragmentModule::class)])
    fun previousImagesFragment(): PerviousImagesFragment


}
