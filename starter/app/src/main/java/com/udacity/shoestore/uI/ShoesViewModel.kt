package com.udacity.shoestore.uI

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.LiveData
import com.udacity.shoestore.models.Shoe


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.shoes.ShoeDetailFragment
import kotlinx.android.synthetic.main.item.view.*

private const val TAG = "ShoesViewModel"

class ShoesViewModel : ViewModel() {
    var _shoe =MutableLiveData<MutableList<Shoe>>()
    val list=ArrayList<Shoe>()

    init {
      Log.i(TAG, ": ")
  }
//var shoe : LiveData<List<Shoe>> =



fun getShoe(shoe: Shoe)
{
    list.add(shoe)
    _shoe.value=list

}
fun add(): MutableList<Shoe>? = _shoe.value

}