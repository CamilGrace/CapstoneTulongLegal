package com.example.tulonglegal

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class ClientRegistrationActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var contactEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var checkBox: CheckBox
    private lateinit var registerButton: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.client_registration)

        nameEditText = findViewById(R.id.name_edit_text)
        contactEditText = findViewById(R.id.contact_edit_text)
        emailEditText = findViewById(R.id.email_edit_text)
        usernameEditText = findViewById(R.id.uname_edit_text)
        passwordEditText = findViewById(R.id.pass_edit_text)
        confirmPasswordEditText = findViewById(R.id.confirmpass_edit_text)
        checkBox = findViewById(R.id.checkBox)
        registerButton = findViewById(R.id.register_button)

        // Set up the "Back" button functionality
        findViewById<View>(R.id.imageBack).setOnClickListener {
            finish() // Close this activity and return to the previous one
        }

        // Add listener to enable register button when terms are accepted
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            registerButton.isEnabled = isChecked
            if (isChecked) {
                registerButton.setBackgroundResource(R.drawable.button_enabled)  // Assuming you have a button_enabled drawable

            } else {
                registerButton.setBackgroundResource(R.drawable.button_disabled)
            }
        }

        // Handle Register Button Click
        registerButton.setOnClickListener {
            if (isValid()) {
                // Proceed with registration logic (e.g., storing data, making API calls)
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValid(): Boolean {
        val name = nameEditText.text.toString()
        val contact = contactEditText.text.toString()
        val email = emailEditText.text.toString()
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()
        val confirmPassword = confirmPasswordEditText.text.toString()

        // Basic validations
        if (name.isEmpty() || contact.isEmpty() || email.isEmpty() ||
            username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!checkBox.isChecked) {
            Toast.makeText(this, "You must accept the terms and conditions", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}
