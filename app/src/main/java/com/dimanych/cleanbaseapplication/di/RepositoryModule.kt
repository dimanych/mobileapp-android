package com.dimanych.cleanbaseapplication.di

import com.dimanych.cleanbaseapplication.data.main.MainHttpRepository
import com.dimanych.cleanbaseapplication.data.main.MainRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideMainRepository(mainRepository: MainHttpRepository): MainRepository

}