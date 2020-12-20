package com.igorcgarcia.dhmarveld3.api

import com.igorcgarcia.dhmarveld3.model.ComicsList
import com.igorcgarcia.dhmarveld3.util.Constants.Api.BASE_COMICS
import retrofit2.Response
import retrofit2.http.GET

interface MarvelApi {

    @GET(BASE_COMICS)
    suspend fun getComics(): Response<ComicsList>

}