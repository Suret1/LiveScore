package com.suret.livescore.ui.entry

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.suret.livescore.R
import com.suret.livescore.login.LoginBottomSheet
import kotlinx.android.synthetic.main.fragment_entry.*


class EntryFragment : Fragment(R.layout.fragment_entry) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loginBottomSheet = LoginBottomSheet()

        sign_in_btn.setOnClickListener {
            loginBottomSheet.show(
                childFragmentManager,
                LoginBottomSheet::javaClass.javaClass.canonicalName
            )
        }

    }

}