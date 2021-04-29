package com.suret.livescore.ui.entry

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.suret.livescore.R
import com.suret.livescore.ui.login.LoginBottomSheet
import com.suret.livescore.ui.signup.SignUpBottomSheet
import kotlinx.android.synthetic.main.fragment_entry.*


class EntryFragment : Fragment(R.layout.fragment_entry) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loginBottomSheet = LoginBottomSheet()
        val signUpBottomSheet = SignUpBottomSheet()

        sign_in_btn.setOnClickListener {
            loginBottomSheet.show(
                childFragmentManager,
                LoginBottomSheet::javaClass.javaClass.canonicalName
            )
        }
        sign_up_btn.setOnClickListener {
            signUpBottomSheet.show(
                childFragmentManager,
                SignUpBottomSheet::javaClass.javaClass.canonicalName
            )
        }


    }

}