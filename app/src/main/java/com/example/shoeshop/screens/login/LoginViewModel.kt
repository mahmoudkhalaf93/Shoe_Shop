package com.example.shoeshop.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private  val _haveToken=  MutableLiveData<Boolean>()
    val haveToken: LiveData<Boolean> get() = _haveToken

    init {
        _haveToken.value=false
    }

    fun tokenGenerated (){
        _haveToken.value=true
    }


}