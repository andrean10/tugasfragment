package com.kontrakanprojects.tugasfragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PageViewModel : ViewModel() {

    private val mName = MutableLiveData<String>()

    val name: LiveData<String>
        get() = mName

    fun setName(name: String) {
        mName.postValue(name)
    }
}