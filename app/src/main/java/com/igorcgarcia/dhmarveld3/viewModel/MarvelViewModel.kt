package com.igorcgarcia.dhmarveld3.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igorcgarcia.dhmarveld3.api.ResponseApi
import com.igorcgarcia.dhmarveld3.business.MarvelBusiness
import com.igorcgarcia.dhmarveld3.model.ComicsList
import com.igorcgarcia.dhmarveld3.util.Constants.Api.BASE_COMICS
import kotlinx.coroutines.launch

class MarvelViewModel: ViewModel() {

    val comicsLiveData = MutableLiveData<ComicsList>()
    val comicsBusiness = MarvelBusiness()
    val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()

    fun getComics() {
        viewModelScope.launch {
            val comics = comicsBusiness.getComics()
            notifyLiveData(comics, BASE_COMICS)
        }
    }

    private fun notifyLiveData(response: ResponseApi, liveData: String) {
        if (response is ResponseApi.Success) {
            when(liveData) {
                BASE_COMICS -> {
                    comicsLiveData.postValue(response.data as? ComicsList)
                }
            }
        } else {
            response as ResponseApi.Error
            errorMessageLiveData.postValue(response.message)
        }
    }
}