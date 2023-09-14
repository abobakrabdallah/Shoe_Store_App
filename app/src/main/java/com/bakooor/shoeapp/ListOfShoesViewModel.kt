package com.bakooor.shoeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListOfShoesViewModel : ViewModel() {

    private val _list = MutableLiveData<List<Shoe>>(emptyList())
    val list: LiveData<List<Shoe>>
        get() = _list

    fun addShoe(shoeName : String ,companyName : String , shoeSize :Int,description:String){
        val shoe = Shoe(shoeName,companyName,shoeSize,description)
        val list = _list.value?.toMutableList()
        list?.add(shoe)
        _list.value = list!!
    }
}


