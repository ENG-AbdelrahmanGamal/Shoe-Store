package com.udacity.sho

import android.util.Log
import com.udacity.shoestore.models.Shoe


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesViewModel : ViewModel() {
    private  val TAG = "ShoesViewModel"
val instance_of_shoe= MutableLiveData<Shoe>()
    var name=""
    var company=""
        var size=0.0
        var dis=""






}