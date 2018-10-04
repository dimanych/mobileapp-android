package com.dimanych.cleanbaseapplication.di

import android.content.Context
import com.dimanych.cleanbaseapplication.CustomApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AppModule::class),
    (ApiModule::class),
    (NavigationModule::class),
    (RepositoryModule::class)]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(application: CustomApplication)

}
