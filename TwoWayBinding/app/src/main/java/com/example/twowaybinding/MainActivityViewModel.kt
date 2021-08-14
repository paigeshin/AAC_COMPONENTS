package com.example.twowaybinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    var userName = MutableLiveData<String>()

    init {
        userName.value = "Paige"
    }

}