package com.udacity.shoestore.uI

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.udacity.shoestore.models.Shoe


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.shoes.ShoeDetailFragment
import kotlinx.android.synthetic.main.item.view.*
import java.util.*

private const val TAG = "ShoesViewModel"

class ShoesViewModel : ViewModel() {
    private  val TAG = "ShoesViewModel"

    val _shoe =MutableLiveData<MutableList<Shoe>>(mutableListOf())
 val  shoe :LiveData<MutableList<Shoe>> get()=_shoe
    init {
      Log.i(TAG, " the result from view:${_shoe.value?.size} ")
      Log.i(TAG, ": ")
    }
  // var itemOfShoe=Shoe("new Style","41","Nile Stock","came this year ")

   // val updateListOfShoe=_shoe.value?.also{ it.add(itemOfShoe) }
    val shoeItemMutableLiveData = MutableLiveData(Shoe("","","",""))

    fun addShoe() {
        _shoe.value?.add(shoeItemMutableLiveData.value!!.copy())
//        _shoe.value?.add(
//            Shoe(
//                    shoeItemMutableLiveData.value!!.name,
//                    shoeItemMutableLiveData.value!!.size,
//                    shoeItemMutableLiveData.value!!.company,
//                    shoeItemMutableLiveData.value!!.description
//            ))
                 } }








//  _shoe.value?.add(itemOfShoe)

//
//_shoe.value?.add(Shoe(shoeItemMutableLiveData.value!!.name
//,shoeItemMutableLiveData.value!!.size
//,shoeItemMutableLiveData.value!!.company
//,shoeItemMutableLiveData.value!!.description))