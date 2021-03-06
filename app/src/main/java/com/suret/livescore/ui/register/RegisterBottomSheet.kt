package com.suret.livescore.ui.register

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.suret.livescore.R
import com.suret.livescore.constants.Constants
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

        val sharedPreferences: SharedPreferences? = requireActivity().getSharedPreferences(
            Constants.userData,
            Context.MODE_PRIVATE
        )
        val editor: SharedPreferences.Editor? = sharedPreferences?.edit()



        sign_up__btn_bottom_sheet.setOnClickListener {

            val email = email_edit_text.text.toString().trim()
            val password = password_edit_text.text.toString().trim()
            val confirmPassword = password_confirm_edit_text.text.toString().trim()

            if (!email.isNullOrEmpty() && !password.isNullOrEmpty() && !confirmPassword.isNullOrEmpty()) {
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    email_text_input_layout.error = "Please Correct Email Address"
                    password_confirm_text_input_layout.isErrorEnabled = false
                }
                else if (password != confirmPassword) {
                    email_text_input_layout.isErrorEnabled = false
                    password_confirm_text_input_layout.error = "Passwords must be the same"
                }
                else if (password.length < 6) {
                    email_text_input_layout.isErrorEnabled = false
                    password_confirm_text_input_layout.error = "Passwords must be than 6"
                } else {
                    progressBar_signUp.visibility = View.VISIBLE
                    firebaseAuth.createUserWithEmailAndPassword(email, confirmPassword)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                editor?.putBoolean(Constants.loginBoolean, true)
                                editor?.apply()
                                editor?.commit()
                                progressBar_signUp.visibility = View.GONE
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
                                progressBar_signUp.visibility = View.GONE
                                Toast.makeText(
                                    requireContext(),
                                    "Register failed",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                }
            } else {
                Snackbar.make(dialog?.window!!.decorView, "Please input", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
    }
}