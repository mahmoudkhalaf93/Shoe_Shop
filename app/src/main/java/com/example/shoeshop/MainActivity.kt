package com.example.shoeshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.shoeshop.databinding.ActivityMainBinding

import timber.log.Timber

class MainActivity : AppCompatActivity() {

    lateinit var appBarConfigration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        val navController = this.findNavController(R.id.nav_controller)
        NavigationUI.setupActionBarWithNavController(this, navController)
        appBarConfigration = AppBarConfiguration(navController.graph)

        Timber.plant(Timber.DebugTree())
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_controller)
        return NavigationUI.navigateUp(navController, appBarConfigration)
    }
}