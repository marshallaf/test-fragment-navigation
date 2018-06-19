package com.marshallaf.testfragmentnavigation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var navigationController: NavigationController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setNavigationController()
        if (navigationController.isEmpty) {
            navigationController.navigate(FragmentA())
        }
    }

    private fun setNavigationController() {
        navigationController = NavigationHolder.getNavigationController(this)
    }
}
