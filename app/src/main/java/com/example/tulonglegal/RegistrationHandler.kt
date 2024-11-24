package com.example.tulonglegal

import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class RegistrationHandler(private val context: Context) {
    private val activity = context as AppCompatActivity

    fun showRegistrationScreen() {
        activity.setContentView(R.layout.user_registration)

        val backButton: View = activity.findViewById(R.id.imageBackArrow)
        backButton.setOnClickListener {
            // Go back to login screen
            LoginHandler(activity).setupLoginScreen()
        }

        val clientButton: View = activity.findViewById(R.id.button_client)
        val lawyerButton: View = activity.findViewById(R.id.button_lawyer)

        clientButton.setOnClickListener {
            toggleClientRegistration(clientButton, lawyerButton)
        }

        lawyerButton.setOnClickListener {
            toggleLawyerRegistration(lawyerButton, clientButton)
        }
    }

    private fun toggleClientRegistration(clientButton: View, lawyerButton: View) {
        clientButton.isSelected = !clientButton.isSelected
        lawyerButton.isSelected = false
        if (clientButton.isSelected) {
            activity.setContentView(R.layout.client_registration)
            val backButtonClient: View = activity.findViewById(R.id.imageBackArrow)
            backButtonClient.setOnClickListener { showRegistrationScreen() }
        }
    }

    private fun toggleLawyerRegistration(lawyerButton: View, clientButton: View) {
        lawyerButton.isSelected = !lawyerButton.isSelected
        clientButton.isSelected = false
        if (lawyerButton.isSelected) {
            activity.setContentView(R.layout.lawyer_registration)
            val backButtonLawyer: View = activity.findViewById(R.id.imageBackArrow)
            backButtonLawyer.setOnClickListener { showRegistrationScreen() }
        }
    }
}
