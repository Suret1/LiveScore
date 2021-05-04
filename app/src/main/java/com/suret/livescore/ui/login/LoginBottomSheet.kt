package com.suret.livescore.ui.login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.suret.livescore.R
import com.suret.livescore.constants.Constants
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

        val sharedPreferences: SharedPreferences? = requireActivity().getSharedPreferences(
            Constants.userData,
            Context.MODE_PRIVATE
        )
        val editor: SharedPreferences.Editor? = sharedPreferences?.edit()

        rememberCheckBox.setOnCheckedChangeListener { buttonView, _ ->
            if (buttonView.isChecked) {
                editor?.putBoolean(Constants.loginBoolean, true)
                editor?.apply()
                editor?.commit()
            } else {
                editor?.putBoolean(Constants.loginBoolean, false)
                editor?.apply()
                editor?.commit()
            }
        }

        sign_in__btn_bottom_sheet.setOnClickListener {
            val email = email_edit_text_sign_in.text.toString().trim()
            val password = password_edit_text_sign_in.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    email_text_input_layout.error = "Please Correct Email Address"
                    password_text_input_layout.isErrorEnabled = false
                } else if (password.length < 6) {
                    email_text_input_layout.isErrorEnabled = false
                    password_text_input_layout.error = "Password must be longer than 6"
                } else {
                    password_text_input_layout.isErrorEnabled = false
                    email_text_input_layout.isErrorEnabled = false
                    progressbar_signIn.visibility = View.VISIBLE
                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {

                            progressbar_signIn.visibility = View.GONE
                            navigation.navigate(R.id.action_to_interestFragment)
                        } else {
                            Snackbar.make(
                                dialog?.window!!.decorView,
                                "Login Failed",
                                Snackbar.LENGTH_SHORT
                            ).show()
                            progressbar_signIn.visibility = View.GONE
                        }
                    }
                }
            } else {
                Snackbar.make(dialog?.window!!.decorView, "Please Input", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }

        sign_up_btn.setOnClickListener {
            navigation.navigate(R.id.action_sign_in_bottom_sheet_to_sign_up_bottom_sheet)
        }


    }

}


