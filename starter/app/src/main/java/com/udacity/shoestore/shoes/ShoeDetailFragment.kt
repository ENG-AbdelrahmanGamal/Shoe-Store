package com.udacity.shoestore.shoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.sho.ShoesViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {
  private lateinit var binding:FragmentShoeDetailBinding
private lateinit var viewModel: ShoesViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding=DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail,container,false)
    binding.buttonCancel.setOnClickListener { view->
    Navigation.findNavController(view).navigate(R.id.action_ShoeDetailFragment_to_listFragment)
}
        binding.buttonSave.setOnClickListener {
          val name =binding.tvNameShoe.toString()
            val company=binding.tvNameCompany.toString()
            val size=binding.etSize.toString()
            val descr=binding.tvNameDescription.toString()
            if(name.isNotEmpty()&&size.isNotEmpty()&&company.isNotEmpty()&&descr.isNotEmpty())
            {
               viewModel.add()
            }
        }
        return binding.root
    }


}