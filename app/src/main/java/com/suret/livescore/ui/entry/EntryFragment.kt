package com.suret.livescore.ui.entry

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.suret.livescore.LoginBottomSheet
import com.suret.livescore.R
import kotlinx.android.synthetic.main.fragment_entry.*


class EntryFragment : Fragment(R.layout.fragment_entry) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val loginBottomSheet = LoginBottomSheet()


        sign_in_btn.setOnClickListener {
            loginBottomSheet.show(childFragmentManager,"com.suret.livescore.ui.LoginBottomSheet")
        }
    }
}