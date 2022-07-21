package com.udacity.shoestore.uI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentOnBroardingBinding
class OnBroardingFragment : Fragment() {
    private lateinit var binding:FragmentOnBroardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding=DataBindingUtil.inflate(inflater,R.layout.fragment_on_broarding,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
binding.goToShoeList.setOnClickListener{
    Navigation.findNavController(view).navigate(R.id.action_onBroardingFragment_to_listFragment2)

}
    }

}