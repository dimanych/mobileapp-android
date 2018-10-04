package com.dimanych.cleanbaseapplication.di

import com.dimanych.cleanbaseapplication.base.HackRouter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

/**
 * @author Dmitrii Grigorev
 */
@Module
class NavigationModule internal constructor() {

    private val cicerone: Cicerone<Router> = Cicerone.create(HackRouter())

    @Provides
    @Singleton
    internal fun provideRouter(): Router {
        return cicerone.router
    }

    @Provides
    @Singleton
    internal fun provideNavigationHolder(): NavigatorHolder {
        return cicerone.navigatorHolder
    }

}
