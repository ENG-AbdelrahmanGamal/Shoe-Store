package com.udacity.shoestore.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import com.udacity.shoestore.shoes.ListFragment
import kotlinx.android.synthetic.main.fragment_shoe_detail.view.*
import java.security.AccessController.getContext

class AddView  (fragment: Context,array: ArrayList<Shoe>){
       val view: View =LayoutInflater.from(fragment).inflate(R.layout.item,null,false)



}