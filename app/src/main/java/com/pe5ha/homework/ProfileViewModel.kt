package com.pe5ha.homework

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel: ViewModel() {
    val profile = MutableLiveData<Person>()
}