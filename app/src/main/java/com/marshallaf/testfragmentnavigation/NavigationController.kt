package com.marshallaf.testfragmentnavigation

import android.support.v4.app.Fragment

interface NavigationController {
    fun navigate(fragment: Fragment)
}