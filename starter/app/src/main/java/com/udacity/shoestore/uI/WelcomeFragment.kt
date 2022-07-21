package com.udacity.shoestore.uI

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding



class WelcomeFragment : Fragment() {

private lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
binding=DataBindingUtil.inflate(inflater,R.layout.fragment_welcome,container,false)


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

  binding.goToInstruction.setOnClickListener{

    Navigation.findNavController(view).navigate(R.id.action_welcomeFragment_to_onBroardingFragment)
}


    }



}