package com.suret.livescore.nested

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.suret.livescore.R
import kotlinx.android.synthetic.main.fragment_nested.*

class NestedFragment : Fragment(R.layout.fragment_nested) {
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController =
            Navigation.findNavController(requireActivity(), R.id.fragment_menu_container)

        bottom_nav_menu.setupWithNavController(navController)

        bottom_nav_menu.setOnNavigationItemReselectedListener { }
    }

}