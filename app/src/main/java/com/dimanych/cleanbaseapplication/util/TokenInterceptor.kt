package com.dimanych.cleanbaseapplication.util

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.HttpURLConnection
import javax.inject.Inject

class TokenInterceptor @Inject internal constructor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val requestBuilder = original.newBuilder()

        val request = requestBuilder
                .build()
        val response = chain.proceed(request)
        if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
            //failed
        }
        return response
    }

}
