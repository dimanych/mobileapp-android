package com.dimanych.cleanbaseapplication.di

import com.dimanych.cleanbaseapplication.BuildConfig
import com.dimanych.cleanbaseapplication.data.main.MainApi
import com.dimanych.cleanbaseapplication.util.TokenInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule {

    companion object {
        const val READ_TIMEOUT = 15
        const val API_HOST = "http://weyveed.herokuapp.com"
    }

    @Provides
    @Singleton
    internal fun proviideLogginInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }

    @Provides
    internal fun provideOkHttpClient(tokenInterceptor: TokenInterceptor,
                                     logginInterceptor: HttpLoggingInterceptor)
            : OkHttpClient = OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .addInterceptor(tokenInterceptor)
            .addInterceptor(logginInterceptor)
            .build()

    @Provides
    internal fun provideGson(): Gson = Gson()

    @Provides
    internal fun provideRetrofitBuilder(gson: Gson, okHttpClient: OkHttpClient)
            : Retrofit.Builder = Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory
                    .createWithScheduler(Schedulers.io()))
            .client(okHttpClient)

    @Provides
    fun provideMainApi(retrofitBuilder: Retrofit.Builder,
                       okHttpClient: OkHttpClient): MainApi = retrofitBuilder
            .baseUrl(API_HOST)
            .client(okHttpClient)
            .build()
            .create(MainApi::class.java)


}