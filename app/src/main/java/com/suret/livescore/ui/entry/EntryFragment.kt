package com.suret.livescore.ui.entry

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.suret.livescore.R
import kotlinx.android.synthetic.main.fragment_entry.*


class EntryFragment : Fragment(R.layout.fragment_entry) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navigation = Navigation.findNavController(requireActivity(), R.id.fragment_container)

        sign_in_btn.setOnClickListener {
            navigation.navigate(R.id.action_entry_to_sign_bottom_sheet)
        }
        sign_up_btn.setOnClickListener {
            navigation.navigate(R.id.action_entry_to_register_bottom_sheet)
        }


    }

}