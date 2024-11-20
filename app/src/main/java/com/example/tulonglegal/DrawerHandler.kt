package com.example.tulonglegal

import android.content.Context
import android.view.View
import androidx.core.view.GravityCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class DrawerHandler(private val context: Context) {
    fun setupDrawer() {
        (context as MainActivity).setContentView(R.layout.client_dashboard)

        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = context.findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = context.findViewById(R.id.navigation_view)
        val bottomNavigationView: BottomNavigationView = context.findViewById(R.id.bottomNavigationView)

        drawerLayout.closeDrawers()
        bottomNavigationView.selectedItemId = R.id.home

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_profile -> { /* Handle Profile click */ }
                R.id.nav_inbox -> { /* Handle Inbox click */ }
                R.id.nav_settings -> { /* Handle Settings click */ }
                R.id.nav_sign_out -> { /* Handle Sign Out click */ }
            }
            drawerLayout.closeDrawers()
            true
        }

        val burgerMenuButton: View = context.findViewById(R.id.img_menu)
        burgerMenuButton.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        val lawyerMatchingContainer: View = context.findViewById(R.id.container_matching)
        lawyerMatchingContainer.setOnClickListener {
            LawyerMatchingHandler(context).setupLawyerMatchingScreen()
        }
    }
}
