package com.example.tulonglegal

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LawyerLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lawyer_login)

        // Find the Sign up text view
        val signupTextView: TextView = findViewById(R.id.signup_text)

        // Set an OnClickListener to navigate to the RegistrationActivity
        signupTextView.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}
