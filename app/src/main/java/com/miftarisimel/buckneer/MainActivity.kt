package com.miftarisimel.buckneer

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)
        navView.elevation = 0f
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id) {
                R.id.loginFragment, R.id.personalFragment, R.id.accountFragment, R.id.titleFragment, R.id.AddProjectFragment -> navView.visibility = View.GONE
                else -> navView.visibility = View.VISIBLE
            }
        }
    }
}
