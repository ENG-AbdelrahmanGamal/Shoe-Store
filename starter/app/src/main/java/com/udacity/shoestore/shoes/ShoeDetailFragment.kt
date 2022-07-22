package com.udacity.shoestore.shoes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.sho.ShoesViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.AddView
import kotlinx.android.synthetic.main.item.view.*
import com.udacity.shoestore.models.Shoe as Shoe1

class ShoeDetailFragment : Fragment() {
  private lateinit var binding:FragmentShoeDetailBinding
    private lateinit var linearLayout: LinearLayout
    private lateinit var shoe:com.udacity.shoestore.models.Shoe
    private lateinit var viewModel: ShoesViewModel
private lateinit var listFragment: ListFragment
    private val TAG = "ShoeDetailFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding=DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail,container,false)
    binding.buttonCancel.setOnClickListener { view->
    Navigation.findNavController(view).navigate(R.id.action_ShoeDetailFragment_to_listFragment)
}

        //linearLayout=binding.linearContainerParent
        //  linearLayout=binding.constraint


        binding.buttonSave.setOnClickListener { view->
          var name =binding.etName.text.toString()
            val company=binding.etCompany.text.toString()
            val size=binding.etSize.text.toString()
            val descr=binding.etDescription.text.toString()
            if(name.isNotEmpty()&&size.isNotEmpty()&&company.isNotEmpty()&&descr.isNotEmpty())
            {
              //  Log.i(TAG, "onCreateView: $name \n $company \n$size")
            ///    shoe.name=name
             //   shoe.company=company
              Navigation.findNavController(view).navigate(R.id.action_ShoeDetailFragment_to_listFragment)
            }
        }
        return binding.root
    }


}