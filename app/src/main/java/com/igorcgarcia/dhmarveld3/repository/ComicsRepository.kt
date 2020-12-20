package com.igorcgarcia.dhmarveld3.repository

import com.igorcgarcia.dhmarveld3.api.MarvelApi
import com.igorcgarcia.dhmarveld3.api.MarvelApiService
import com.igorcgarcia.dhmarveld3.api.MarvelApiService.marvelServiceAPI
import com.igorcgarcia.dhmarveld3.api.MarvelResponseValidation
import com.igorcgarcia.dhmarveld3.api.ResponseApi

class ComicsRepository {
    //TODO CHANGE ERROR MESSAGE -: CHANGE PAGE NUMBER
    val marvelService = MarvelApiService.marvelServiceAPI
    val responseValidation = MarvelResponseValidation.DefaultResponseValidation()

    suspend fun getComics(movieId: Int): ResponseApi {
        return movieResponseValidation.moviesDefaultResponseValidation(
            MarvelApi.getComics(), "DEU RUIM!")
    }
}