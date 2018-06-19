package com.marshallaf.testfragmentnavigation

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.util.Log

class NavigationController(activity: AppCompatActivity) {

    val isEmpty get() = fragmentManager.fragments.isEmpty()

    var fragmentManager: FragmentManager = activity.supportFragmentManager

    fun navigate(fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction().replace(android.R.id.content, fragment)
        if (!fragmentManager.fragments.isEmpty()) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }

    fun refresh(activity: AppCompatActivity) {
        fragmentManager = activity.supportFragmentManager
    }

    fun printBackStack() {
        Log.d("NavigationController", "Current backstack for ${hashCode()}, with fragmentManager ${fragmentManager.hashCode()}:")
        for (i in 0 until fragmentManager.backStackEntryCount) {
            Log.d("NavigationController", "  ------ $i --- ${fragmentManager.getBackStackEntryAt(i).id}")
        }
    }
}