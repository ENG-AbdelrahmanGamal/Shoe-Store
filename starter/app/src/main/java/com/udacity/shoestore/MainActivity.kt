package com.udacity.shoestore


import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
    setSupportActionBar(toolbar)

        val navController = this.findNavController(R.id.fragment_container )
        NavigationUI.setupActionBarWithNavController(this,navController)
    }
    //


    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.fragment_container)
        return navController.navigateUp()
    }


}
