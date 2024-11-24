package com.example.tulonglegal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_registration) // Make sure this layout exists

        // Initialize the RegistrationHandler to manage registration functionality
        RegistrationHandler(this).showRegistrationScreen()
    }
}
