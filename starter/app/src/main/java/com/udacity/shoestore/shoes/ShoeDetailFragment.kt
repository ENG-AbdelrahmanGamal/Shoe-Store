package com.udacity.shoestore.shoes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.uI.ShoesViewModel
import java.util.concurrent.atomic.DoubleAdder

class ShoeDetailFragment : Fragment() {
  private lateinit var binding:FragmentShoeDetailBinding
    private lateinit var viewModel: ShoesViewModel
    private val TAG = "ShoeDetailFragment"
    private var newShoe= Shoe("",33.00,"","")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    binding=DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail,container,false)
        viewModel = ShoesViewModel()
        Log.i(TAG, "onCreateView: called view Model provider ")

        viewModel = ViewModelProvider(requireActivity()).get(ShoesViewModel::class.java)

        binding.buttonCancel.setOnClickListener { view->
    Navigation.findNavController(view).navigate(R.id.action_ShoeDetailFragment_to_listFragment)
}
        Log.i(TAG, "onCreateView: ${binding.etName.text}")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSave.setOnClickListener {
            var shoe=Shoe(binding.etName.getText().toString(),
                (binding.etSize.getText().toString().toDoubleOrNull()?:0.0),
                binding.etCompany.text.toString(),
                binding.etDescription.text.toString())
            newShoe=shoe

            //shoe.size =  Integer.valueOf(binding.etSize.text.toString())
            Navigation.findNavController(view).navigate(R.id.action_ShoeDetailFragment_to_listFragment)
            viewModel.getShoe(newShoe)}

    }


}