package com.udacity.shoestore.shoes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.ItemBinding
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

            viewModel = ViewModelProvider(requireActivity()).get(ShoesViewModel::class.java)

            val shoe=Shoe(binding.etName.getText().toString(),
                (binding.etSize.getText().toString().toDoubleOrNull()?:0.0),
                binding.etCompany.text.toString(),
                binding.etDescription.text.toString())
                  newShoe=shoe

if (shoe.name.isNotEmpty()&& shoe.company.isNotEmpty()&&shoe.size.toString().isNotEmpty()&&shoe.description.isNotEmpty()) {
    Navigation.findNavController(view).navigate(R.id.action_ShoeDetailFragment_to_listFragment)
    viewModel.getShoe(newShoe)
} else{
    Toast.makeText(requireContext(),"Please fill all the data Required ",Toast.LENGTH_LONG)

}
        }

    }


}


//            viewModel._shoe.observe(viewLifecycleOwner) { newShoe ->
//                newShoe.forEachIndexed { index, shoe ->
//                    val itemBinding= ItemBinding.inflate(layoutInflater)
//                    itemBinding.shoe=shoe
//
//                    shoe.name = binding.etName.text.toString()
//                    shoe.company = binding.etCompany.text.toString()
//                    shoe.size=binding.etSize.text.toString().toDoubleOrNull()?:0.0
//                    shoe.description=binding.etDescription.text.toString()
//                    binding.viewModel = viewModel
//
//                }
//
//
//
//            }
//
//            viewModel._shoe.observe(viewLifecycleOwner) { newShoe ->
//                newShoe.forEachIndexed { index, shoe ->
//                    val itemBinding= ItemBinding.inflate(layoutInflater)
//                    itemBinding.shoe=shoe
//
//                    shoe.name = binding.etName.text.toString()
//                    shoe.company = binding.etCompany.text.toString()
//                    shoe.size=binding.etSize.text.toString().toDoubleOrNull()?:0.0
//                    shoe.description=binding.etDescription.text.toString()
//                    binding.viewModel = viewModel
//
//                }
//

//
//            }
//