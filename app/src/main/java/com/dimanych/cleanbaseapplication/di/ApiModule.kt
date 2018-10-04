package com.dimanych.cleanbaseapplication.di

import com.dimanych.cleanbaseapplication.di.activity.ActivityScope
import com.dimanych.cleanbaseapplication.util.TokenInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
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
        const val READ_TIMEOUT = 3
    }

    @Provides
    @Singleton
    internal fun provideNetworkInterceptors(): List<Interceptor> {
        return listOf<Interceptor>(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    }

    @Provides
    internal fun provideOkHttpClient(tokenInterceptor: TokenInterceptor,
                                     @ActivityScope networkInterceptors:
                                     List<@JvmSuppressWildcards Interceptor>)
            : OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .addInterceptor(tokenInterceptor)
        networkInterceptors.forEach { okHttpClientBuilder.addInterceptor(it) }
        return okHttpClientBuilder
                .build()
    }

    @Provides
    internal fun provideGson(): Gson = Gson()

    @Provides
    internal fun provideRetrofitBuilder(gson: Gson, okHttpClient: OkHttpClient)
            : Retrofit.Builder {
        return Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory
                        .createWithScheduler(Schedulers.io()))
                .client(okHttpClient)
    }


}