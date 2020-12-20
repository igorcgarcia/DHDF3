package com.igorcgarcia.dhmarveld3.api

import com.igorcgarcia.dhmarveld3.util.Constants.Api.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarvelApiService {
    val marvelServiceAPI = getClient().create(MarvelApi::class.java)

    private fun getClient(): Retrofit {
        val interceptor = DefaultInterceptor.defaultInterceptor
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(interceptor)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}