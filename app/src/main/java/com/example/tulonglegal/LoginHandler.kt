package com.example.tulonglegal

import android.content.Context
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginHandler(private val context: Context) {
    fun setupLoginScreen() {
        (context as MainActivity).setContentView(R.layout.user_login)

        val lawyerLogin: TextView = context.findViewById(R.id.lawyer_login)
        lawyerLogin.setOnClickListener {
            context.setContentView(R.layout.lawyer_login)
        }

        val signUpText: TextView = context.findViewById(R.id.signup_text)
        signUpText.setOnClickListener {
            RegistrationHandler(context).showRegistrationScreen()
        }

        val emailEditText: EditText = context.findViewById(R.id.username_edit_text)
        val passwordEditText: EditText = context.findViewById(R.id.password_edit_text)

        val loginButton: Button = context.findViewById(R.id.login_button)
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isBlank()) {
                Toast.makeText(context, "Please enter your email", Toast.LENGTH_SHORT).show()
            } else if (password.isBlank()) {
                Toast.makeText(context, "Please enter your password", Toast.LENGTH_SHORT).show()
            } else {
                DrawerHandler(context).setupDrawer()
            }
        }
    }
}
