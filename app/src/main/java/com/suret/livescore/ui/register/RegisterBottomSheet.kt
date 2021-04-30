package com.suret.livescore.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.suret.livescore.R
import kotlinx.android.synthetic.main.sign_up_bottom_sheet.*

class RegisterBottomSheet : BottomSheetDialogFragment() {
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_up_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()


        sign_up__btn_bottom_sheet.setOnClickListener {

            val email = email_edit_text.text.toString().trim()
            val password = password_edit_text.text.toString().trim()
            val confirmPassword = password_confirm_edit_text.text.toString().trim()

            if (!email.isNullOrEmpty() && !password.isNullOrEmpty() && !confirmPassword.isNullOrEmpty()) {
                if (!password.equals(confirmPassword)) {
                    password_confirm_text_input_layout.error = "Passwords must be the same"
                } else {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                Toast.makeText(
                                    requireContext(),
                                    "Registered successfully",
                                    Toast.LENGTH_LONG
                                ).show()
                                Navigation.findNavController(
                                    requireActivity(),
                                    R.id.fragment_container
                                )
                                    .navigate(R.id.action_to_interestFragment)
                            } else {
                                Toast.makeText(
                                    requireContext(),
                                    "Register failed",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                }
            }
        }

    }
}