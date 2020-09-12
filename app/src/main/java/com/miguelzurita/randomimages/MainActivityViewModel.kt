package com.miguelzurita.randomimages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var urlImage: MutableLiveData<String>? = null

    fun callURLImage(): MutableLiveData<String>? {
        if (urlImage == null) {
            urlImage = MutableLiveData()
            randomNumbersURL()
        }
        return urlImage
    }

    fun randomNumbersURL() {
        urlImage?.value = "https://picsum.photos/${(3..5).random()}00/${(3..5).random()}00"
    }
}