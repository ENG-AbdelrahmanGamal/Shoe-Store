package com.udacity.shoestore.shoes

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListBinding
import com.udacity.shoestore.models.AddView
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.item.view.*


class ListFragment : Fragment() {

private lateinit var linearLayout: LinearLayout
private lateinit var binding:FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=DataBindingUtil.inflate(inflater,
           com.udacity.shoestore.R.layout.fragment_list,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


         linearLayout=binding.linearContainerParent
        for (i in 0..5)
        addSubView("sports","Active")

        binding.floatingactionbutton.setOnClickListener{
   Navigation.findNavController(view).navigate(R.id.action_listFragment_to_ShoeDetailFragment)
        }

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


   fun getData()
   {
       val shoeDetailFragment= ShoeDetailFragment()

   }

    fun addSubView(name:String,company:String)
    {
        view?.tv_item_Company?.setText(company)
        view?.tv_item_name?.setText(name)

        val addView= AddView(requireContext())
        linearLayout.addView(addView.view)

        linearLayout.setOnClickListener{
            Toast.makeText(activity," building soon (pop up menu )",Toast.LENGTH_LONG).show()
        }

    }
}




