package com.example.shoeshop.screens.shoe_listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoeshop.models.Shoe

class ShoeListingViewModel : ViewModel() {

 private val _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList : LiveData<ArrayList<Shoe>> get() = _shoeList

     val name = MutableLiveData<String>()
  //  val name : LiveData<String> get() = _name

     val size = MutableLiveData<String>()
  //  val size : LiveData<String> get() = _size

     val company = MutableLiveData<String>()
   // val company : LiveData<String> get() = _company

     val description = MutableLiveData<String>()
   // val description : LiveData<String> get() = _description

    init {
       name.value=""
       size.value=""
       company.value=""
       description.value=""
        _shoeList.value = ArrayList()
    }

    fun updateList(){

        _shoeList.value!!.add(Shoe(name.value!!,size.value!!.toDouble(),company.value!!,description.value!!))
        name.value=""
        size.value=""
        company.value=""
        description.value=""
    }

}