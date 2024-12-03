package com.example.tulonglegal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.tulonglegal.databinding.ClientProfileBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class ClientProfileActivity : AppCompatActivity() {

    private lateinit var binding: ClientProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ClientProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the DrawerLayout, NavigationView, and BottomNavigationView from the binding
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navigationView: NavigationView = binding.navigationView
        val bottomNavigationView: BottomNavigationView = binding.bottomNavigationView

        // Open the Drawer when the menu icon is clicked
        binding.imgMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Handle Drawer NavigationItem selection
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_profile -> {
                    // Navigate to Dashboard Activity
                    startActivity(Intent(this, ClientDashboardActivity::class.java))
                }
                R.id.nav_settings -> {
                    // Navigate to Settings Activity
                    startActivity(Intent(this, ClientSettingsActivity::class.java))
                }
                // Add more navigation items as needed
            }

            // Close the drawer after an item is selected
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Handle Bottom Navigation selection
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.person -> {
                    // Already in the Profile Activity; no action needed
                    true
                }
                R.id.home -> {
                    // Navigate to Dashboard Activity
                    startActivity(Intent(this, ClientDashboardActivity::class.java))
                    true
                }
                R.id.settings -> {
                    // Navigate to Settings Activity
                    startActivity(Intent(this, ClientSettingsActivity::class.java))
                    true
                }
                else -> false
            }
        }

        // Set the default selected item in Bottom Navigation to Person
        bottomNavigationView.selectedItemId = R.id.person
    }

    override fun onResume() {
        super.onResume()

        // Ensure the Bottom Navigation highlights the Person icon
        binding.bottomNavigationView.selectedItemId = R.id.person
    }
}
