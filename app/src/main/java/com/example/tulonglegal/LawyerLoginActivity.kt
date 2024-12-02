package com.example.tulonglegal

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.tulonglegal.databinding.LawyerLoginBinding

class LawyerLoginActivity : AppCompatActivity() {

    private lateinit var binding: LawyerLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = LawyerLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the "Back" button functionality
        binding.imageBack.setOnClickListener {
            finish() // Close this activity and return to the previous one
        }

        // Add TextWatchers for the username and password fields
        binding.usernameEditText.addTextChangedListener(loginTextWatcher)
        binding.passwordEditText.addTextChangedListener(loginTextWatcher)

        // Set the click listener for "Sign up here" text
        binding.signupText.setOnClickListener {
            val intent = Intent(this, RoleRegistrationActivity::class.java)
            startActivity(intent)  // Start RoleRegistrationActivity
        }
    }

    private val loginTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val usernameInput = binding.usernameEditText.text.toString().trim()
            val passwordInput = binding.passwordEditText.text.toString().trim()

            // Enable the button only if both fields are not empty
            val isInputValid = usernameInput.isNotEmpty() && passwordInput.isNotEmpty()
            binding.loginButton.isEnabled = isInputValid

            // Change button background based on its state
            val buttonBackground = if (isInputValid) {
                R.drawable.button_enabled // Your enabled button background
            } else {
                R.drawable.button_disabled // Your disabled button background
            }
            binding.loginButton.background = ContextCompat.getDrawable(this@LawyerLoginActivity, buttonBackground)

            // Change button text color based on its state
            val buttonTextColor = if (isInputValid) {
                ContextCompat.getColor(this@LawyerLoginActivity, android.R.color.white) // White text when enabled
            } else {
                ContextCompat.getColor(this@LawyerLoginActivity, android.R.color.black) // Dark gray text when disabled
            }
            binding.loginButton.setTextColor(buttonTextColor)
        }

        override fun afterTextChanged(s: Editable?) {}
    }
}
