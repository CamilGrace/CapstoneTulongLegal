package com.example.tulonglegal

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.tulonglegal.databinding.UserLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: UserLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = UserLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Add TextWatchers for the username and password fields
        binding.usernameEditText.addTextChangedListener(loginTextWatcher)
        binding.passwordEditText.addTextChangedListener(loginTextWatcher)

        // Set up the listener for "Login for Legal Professionals"
        binding.lawyerLogin.setOnClickListener {
            // Navigate to LawyerLoginActivity
            val intent = Intent(this, LawyerLoginActivity::class.java)
            startActivity(intent)
        }

        // Set up the listener for "Sign up here"
        binding.signupText.setOnClickListener {
            // Navigate to RoleRegistrationActivity
            val intent = Intent(this, RoleRegistrationActivity::class.java)
            startActivity(intent)
        }

        // Set up the listener for the Login Button
        binding.loginButton.setOnClickListener {
            // Validate credentials (simplified for now, replace with actual logic)
            val usernameInput = binding.usernameEditText.text.toString().trim()
            val passwordInput = binding.passwordEditText.text.toString().trim()

            if (usernameInput.isNotEmpty() && passwordInput.isNotEmpty()) {
                // Navigate to ClientDashboardActivity
                val intent = Intent(this, ClientDashboardActivity::class.java)
                startActivity(intent)
                finish()  // Optional: Close the login screen
            } else {
                // Handle login failure (e.g., show a toast or alert)
            }
        }
    }

    private val loginTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val usernameInput = binding.usernameEditText.text.toString().trim()
            val passwordInput = binding.passwordEditText.text.toString().trim()

            // Enable the login button only if both fields are not empty
            val isInputValid = usernameInput.isNotEmpty() && passwordInput.isNotEmpty()
            binding.loginButton.isEnabled = isInputValid

            // Change button background based on its state
            val buttonBackground = if (isInputValid) {
                R.drawable.button_enabled // Your enabled button background
            } else {
                R.drawable.button_disabled // Your disabled button background
            }
            binding.loginButton.background = ContextCompat.getDrawable(this@LoginActivity, buttonBackground)

            // Change button text color based on its state
            val buttonTextColor = if (isInputValid) {
                ContextCompat.getColor(this@LoginActivity, android.R.color.white) // White text when enabled
            } else {
                ContextCompat.getColor(this@LoginActivity, android.R.color.black) // Dark gray text when disabled
            }
            binding.loginButton.setTextColor(buttonTextColor)
        }

        override fun afterTextChanged(s: Editable?) {}
    }
}
