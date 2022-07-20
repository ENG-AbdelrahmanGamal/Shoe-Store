package com.udacity.shoestore.shoes

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListBinding
import com.udacity.shoestore.models.AddView
import kotlinx.android.synthetic.main.activity_main.*


class ListFragment : Fragment() {

private lateinit var binding:FragmentListBinding
private lateinit var linearLayout: LinearLayout
private lateinit var toolbar:android.widget.Toolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=DataBindingUtil.inflate(inflater,
           com.udacity.shoestore.R.layout.fragment_list,container,false)
        setHasOptionsMenu(true)
       // toolbar=MainActivity().findViewById(R.id.toolbar)
        return binding.root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        linearLayout=binding.linearContainerParent
        for(i in 1..10) addSubView()
        binding.floatingactionbutton.setOnClickListener{
   Navigation.findNavController(view).navigate(R.id.action_listFragment_to_shoeDetailFragment)
        }



    }

private fun addSubView()
{
val addView=AddView(requireContext())
linearLayout.addView(addView.view)

}
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item?.itemId){
R.id.item_about ->{
    Navigation.findNavController(requireView()).navigate(R.id.action_listFragment_to_onBroardingFragment)
}
    R.id.item_logout->{
        Navigation.findNavController(requireView()).navigate(R.id.action_listFragment_to_loginFragment)

    }
            else->super.onOptionsItemSelected(item)
        }
        return NavigationUI.onNavDestinationSelected(item!!, requireView()!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

}


