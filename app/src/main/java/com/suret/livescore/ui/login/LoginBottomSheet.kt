package com.suret.livescore.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.suret.livescore.R
import kotlinx.android.synthetic.main.sign_in_bottom_sheet.*

class LoginBottomSheet : BottomSheetDialogFragment() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_in_bottom_sheet, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navigation = Navigation.findNavController(requireActivity(), R.id.fragment_container)
        firebaseAuth = FirebaseAuth.getInstance()

        sign_in__btn_bottom_sheet.setOnClickListener {
            val email = email_edit_text_sign_in.text.toString().trim()
            val password = password_edit_text_sign_in.text.toString().trim()
            navigation.navigate(R.id.action_to_interestFragment)

//            if (!email.isNullOrEmpty() && !password.isNullOrEmpty())
//                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
//                    if (it.isSuccessful) {
//                        Toast.makeText(requireContext(), "Successfully", Toast.LENGTH_LONG)
//                            .show()
//
//                    } else {
//                        Toast.makeText(requireContext(), "Failed", Toast.LENGTH_LONG)
//                            .show()
//                    }
//                }

        }
        sign_up_btn.setOnClickListener {
            navigation.navigate(R.id.action_sign_in_bottom_sheet_to_sign_up_bottom_sheet)
        }

    }
}
