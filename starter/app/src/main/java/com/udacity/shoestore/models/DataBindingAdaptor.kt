package com.udacity.shoestore.models

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.udacity.shoestore.uI.ShoesViewModel
import org.w3c.dom.Text

class DataBindingAdaptor {

    @BindingAdapter("imageUrl", "error")
    fun loadImage(view: ImageView, url: String, error: Drawable) {
        Picasso.get().load(url).error(error).into(view)
    }

    @BindingAdapter("shoe", "shoe Temblet")
    fun displayShoe(view: TextView, item: Shoe, error: Drawable) {
        ShoesViewModel()._shoe.value
    }

}