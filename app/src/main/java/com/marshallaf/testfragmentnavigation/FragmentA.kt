package com.marshallaf.testfragmentnavigation

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marshallaf.testfragmentnavigation.R.id.button_to_fragment_b
import kotlinx.android.synthetic.main.fragment_a.*

class FragmentA : Fragment() {

    lateinit var navigationController: NavigationController

    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewModelProviders.of(this).get(ViewModelA::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        navigationController = NavigationHolder.getNavigationController(this)
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onStart() {
        super.onStart()
        button_to_fragment_b.setOnClickListener {
            view ->
                Log.d("FragmentA", "buttonToFragmentB clicked")
                navigationController.navigate(FragmentB())
        }
    }


}
