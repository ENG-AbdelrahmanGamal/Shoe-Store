package com.udacity.shoestore.shoes

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListBinding
import com.udacity.shoestore.models.AddView
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.uI.ShoesViewModel
import kotlinx.android.synthetic.main.item.view.*
import org.w3c.dom.Text


class ListFragment : Fragment() {
    private val TAG = "ListFragment"
    lateinit var linearLayout: LinearLayout
    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: ShoesViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_list, container, false)
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(ShoesViewModel::class.java)
        binding.model=viewModel
        binding.lifecycleOwner=this
        viewModel._shoe.observe(viewLifecycleOwner) {
             itemShoe ->
                itemShoe.forEachIndexed { index, shoe ->
                    val view: View= layoutInflater.inflate(R.layout.item, null)
                    view.tv_item_name.setText(shoe.name)
                    view.tv_item_Company.setText(shoe.company)
                    view.tv_item_size?.setText(shoe.size.toString())
                    view.tv_item_Description.setText(shoe.description)
                    linearLayout = binding.linearContainerParent
                    linearLayout.addView(view)


                }
            }

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

}




