package com.marshallaf.testfragmentnavigation

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log

object NavigationHolder {

    private val navigationControllers = mutableMapOf<Class<AppCompatActivity>, NavigationController>()

    fun getNavigationController(activity: AppCompatActivity): NavigationController {
        return if (navigationControllers.containsKey(activity.javaClass)) {
            Log.d("NavigationHolder", "Returning previously created nav controller for ${activity.javaClass.simpleName}")
            val navigationController = navigationControllers[activity.javaClass] ?: throw IllegalStateException()
            navigationController.printBackStack()
            navigationController.refresh(activity)
            navigationController.printBackStack()
            navigationController
        } else {
            Log.d("NavigationHolder", "Returning new nav controller for ${activity.javaClass.simpleName}")
            val navigationController = NavigationController(activity)
            navigationControllers[activity.javaClass] = navigationController
            navigationController
        }
    }

    fun hasNavigationController(activity: AppCompatActivity): Boolean {
        return navigationControllers.containsKey(activity.javaClass)
    }

    fun getNavigationController(fragment: Fragment): NavigationController {
        val currentParent: AppCompatActivity = fragment.activity as AppCompatActivity
        if (fragment.activity is AppCompatActivity && hasNavigationController(currentParent)) return getNavigationController(currentParent)
        throw IllegalStateException("View ${fragment.hashCode()} has no NavigationController set in its hierarchy tree.")
    }
}