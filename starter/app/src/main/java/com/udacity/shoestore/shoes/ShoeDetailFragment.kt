package com.udacity.shoestore.shoes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.*
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.ItemBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.uI.ShoesViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.view.*
import java.util.concurrent.atomic.DoubleAdder

class ShoeDetailFragment : Fragment() {

  private lateinit var binding:FragmentShoeDetailBinding

    private  lateinit var viewModel: ShoesViewModel
    private val TAG = "ShoeDetailFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    binding=DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail,container,false)

        binding.buttonCancel.setOnClickListener { view->
    Navigation.findNavController(view).navigate(R.id.action_ShoeDetailFragment_to_listFragment)
}
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSave.setOnClickListener {
         val view: View= layoutInflater.inflate(R.layout.item, null)
        viewModel = ViewModelProvider(requireActivity()).get(ShoesViewModel::class.java)
            binding.viewModel=viewModel
            binding.lifecycleOwner=requireActivity()
              viewModel.addShoe()
            binding.constraint.addView(view)

            if(binding.etName.text.isNotEmpty()&&
              binding.etCompany.text.isNotEmpty()&&
               binding.tvNameSize.text.isNotEmpty() &&
                binding.tvNameDescription.text.isNotEmpty()
          )
          {
         Navigation.findNavController(requireView()).navigate(R.id.action_ShoeDetailFragment_to_listFragment)

          }
            else{
                Toast.makeText(requireActivity(),"pleaseFil all the data required ",Toast.LENGTH_LONG)
            }

        }


       }

    }

