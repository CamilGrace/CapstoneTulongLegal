package com.example.tulonglegal

import android.content.Context
import android.view.View

class LawyerMatchingHandler(private val context: Context) {
    fun setupLawyerMatchingScreen() {
        (context as MainActivity).setContentView(R.layout.lawyer_matching)

        val backButton: View = context.findViewById(R.id.imageBackArrow)
        backButton.setOnClickListener {
            DrawerHandler(context).setupDrawer()
        }
    }
}
