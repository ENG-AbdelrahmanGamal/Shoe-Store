package com.udacity.sho

import com.udacity.shoestore.models.Shoe


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesViewModel : ViewModel() {
val instance_of_shoe= MutableLiveData<Shoe>()
    var name=""
    var company=""
        var size=0.0
        var dis=""

    fun add()
    {
val shoe=Shoe(name,size,company,dis)
       // instance_of_shoe.observe()
    }


}