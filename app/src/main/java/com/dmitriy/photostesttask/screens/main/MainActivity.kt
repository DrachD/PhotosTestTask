package com.dmitriy.photostesttask.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.dmitriy.photostesttask.R
import com.dmitriy.photostesttask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        val navController = rootNavController()
        prepareRootNavController(navController)
    }

    private fun rootNavController(): NavController {
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        return navHost.navController
    }

    private fun prepareRootNavController(navController: NavController) {
        val graph =  navController.navInflater.inflate(getMainGraphNavigation())
        graph.setStartDestination(getHomeDestination())
        navController.graph = graph
    }

    private fun getHomeDestination() = R.id.homeFragment
    private fun getMainGraphNavigation() = R.navigation.main_graph
}