package com.igorcgarcia.dhmarveld3.repository

import com.igorcgarcia.dhmarveld3.api.MarvelApiService.marvelServiceAPI
import com.igorcgarcia.dhmarveld3.api.MarvelResponseValidation
import com.igorcgarcia.dhmarveld3.api.ResponseApi

class ComicsRepository {
    //TODO CHANGE ERROR MESSAGE -: CHANGE PAGE NUMBER
    val marvelService = marvelServiceAPI
    val responseValidation = MarvelResponseValidation()

    suspend fun getComics(): ResponseApi {
        return responseValidation.DefaultResponseValidation(
                marvelService.getComics(), "DEU RUIM!")
    }
}