package com.igorcgarcia.dhmarveld3.api

import com.igorcgarcia.dhmarveld3.util.Constants.Api.HEADER_CONTENT_FIELD
import com.igorcgarcia.dhmarveld3.util.Constants.Api.HEADER_CONTENT_TYPE
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object DefaultInterceptor {
    val defaultInterceptor = getInterceptorClient()

    private fun getInterceptorClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader(HEADER_CONTENT_FIELD, HEADER_CONTENT_TYPE)
                    .build()
                chain.proceed(newRequest)
            }

        return interceptor.build()
    }
}