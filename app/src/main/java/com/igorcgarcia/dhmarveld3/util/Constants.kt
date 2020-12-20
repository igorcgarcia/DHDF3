package com.igorcgarcia.dhmarveld3.util

class Constants {

    object Api {
        const val BASE_URL = "http://gateway.marvel.com/v1/public/"
        const val BASE_COMICS = "comics/"
        const val QUERY_FORMAT_NAME = "format"
        const val QUERY_FORMAT_VALUE = "comic"
        const val QUERY_FORMATTYPE_NAME = "formatType"
        const val QUERY_FORMATTYPE_VALUE = "comic"
        const val API_KEY_NAME = "apikey"
        const val API_KEY_VALUE = "6eb7e8896ec5850c52515a8a23ee97"
        const val API_HASHKEY_NAME = "hash"
        const val API_PRIVATEKEY_VALUE = "0dd0c16fedb8a02985977eafca66b49f5e6a526f"
        const val API_TS_NAME = "ts"
        const val API_TS_VALUE = "1"
        const val HEADER_CONTENT_FIELD = "Content-Type"
        const val HEADER_CONTENT_TYPE = "application/json;charset=utf-8"
    }

    object Paging {
        const val PAGE_SIZE = 20
        const val FIRST_PAGE = 1
    }

    object ComicsDetail {
        const val KEY_INTENT_COMIC_NUMBER = "comicNumber"
    }
}