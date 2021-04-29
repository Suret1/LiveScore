package com.suret.livescore.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.suret.livescore.R
import com.suret.livescore.ui.signup.SignUpBottomSheet
import kotlinx.android.synthetic.main.sign_in_bottom_sheet.*
import kotlinx.android.synthetic.main.sign_up_bottom_sheet.*

class LoginBottomSheet : BottomSheetDialogFragment() {
    private val signUpBottomSheet = SignUpBottomSheet()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_in_bottom_sheet, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sign_in__btn_bottom_sheet.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.fragment_container)
                .navigate(R.id.action_to_interestFragment)
        }

        sign_up_bottom_sheet.setOnClickListener {
            signUpBottomSheet.show(
                childFragmentManager,
                SignUpBottomSheet::javaClass.javaClass.canonicalName
            )

        }
    }


}