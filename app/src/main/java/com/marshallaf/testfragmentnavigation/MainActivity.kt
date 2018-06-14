package com.marshallaf.testfragmentnavigation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity(), NavigationController {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setNavigationController()
        navigate(FragmentA())
    }

    private fun setNavigationController() {
        val root = findViewById<View>(android.R.id.content)
        root.setTag(R.id.navigation_controller, this)
    }

    override fun navigate(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction().replace(android.R.id.content, fragment)
        if (!supportFragmentManager.fragments.isEmpty()) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }
}
