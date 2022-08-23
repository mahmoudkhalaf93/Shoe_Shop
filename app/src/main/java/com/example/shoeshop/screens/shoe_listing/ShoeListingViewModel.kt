package com.example.shoeshop.screens.shoe_listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoeshop.models.Shoe

class ShoeListingViewModel : ViewModel() {
 private val _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList : LiveData<ArrayList<Shoe>> get() = _shoeList
    init {
        _shoeList.value = ArrayList()
    }

    fun updateList(shoeItem : Shoe){
        _shoeList.value!!.add(shoeItem)
    }

}