package com.igorcgarcia.dhmarveld3.business

import com.igorcgarcia.dhmarveld3.api.ResponseApi
import com.igorcgarcia.dhmarveld3.repository.ComicsRepository

class MarvelBusiness {

    private val comicsRepository: ComicsRepository by lazy {
        ComicsRepository()
    }

    suspend fun getComics(): ResponseApi {
        return comicsRepository.getComics()
    }


}