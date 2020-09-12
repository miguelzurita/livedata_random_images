package com.miguelzurita.randomimages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    var size: MutableLiveData<String> = MutableLiveData<String>()

    private var urlImage: MutableLiveData<String>? = null

    fun getURLImageLiveData(): MutableLiveData<String>? {
        if (urlImage == null) {
            urlImage = MutableLiveData()
            changeRandomImage()
        }
        return urlImage
    }

    fun changeRandomImage() {
        val random = (3..5).random()
        size.value = "Size ${random}"
        urlImage?.value = "https://picsum.photos/${random}00/${random}00"
    }
}