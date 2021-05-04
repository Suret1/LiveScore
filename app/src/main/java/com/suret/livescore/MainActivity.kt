package com.suret.livescore

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.suret.livescore.constants.Constants
import com.suret.livescore.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var user: FirebaseUser
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        newsViewModel.getData()


        firebaseAuth = FirebaseAuth.getInstance()


        val sharedPreferences: SharedPreferences? = this.getSharedPreferences(
            Constants.userData,
            Context.MODE_PRIVATE
        )

        val isLogged = sharedPreferences?.getBoolean(Constants.loginBoolean, false)

        if (isLogged == true) {
            try {
                user = firebaseAuth.currentUser
                if (user != null) {
                    Navigation.findNavController(this, R.id.fragment_container)
                        .navigate(R.id.action_entryFragment_to_nestedFragment)
                } else {
                    Toast.makeText(this, "Signed out", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {

            }
        }

    }

}