package com.marshallaf.testfragmentnavigation

import android.util.Log
import android.view.View

object NavigationRetriever {

    fun getNavigationController(view: View): NavigationController {
        var currentView: View? = view
        do {
            val controller = currentView?.getTag(R.id.navigation_controller)
            if (controller is NavigationController) return controller
            currentView = if (currentView?.parent is View) currentView.parent as View else null
        } while (currentView != null)
        throw IllegalStateException("View ${view.hashCode()} has no NavigationController set in its hierarchy tree.")
    }
}