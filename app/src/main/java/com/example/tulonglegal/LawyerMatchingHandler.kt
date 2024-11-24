package com.example.tulonglegal

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class LawyerMatchingHandler(private val context: Context) {

    fun setupLawyerMatchingScreen() {
        (context as MainActivity).setContentView(R.layout.lawyer_matching)

        // Set up the back button
        val backButton: View = context.findViewById(R.id.imageBack)
        backButton.setOnClickListener {
            // Navigate back to the previous screen
            DrawerHandler(context).setupDrawer()
        }

        // Set up the Spinner
        setupSpinner()
    }

    private fun setupSpinner() {
        val spinner: Spinner = (context as MainActivity).findViewById(R.id.spinnerLegalCategory)

        // Retrieve categories from resources
        val legalCategories = context.resources.getStringArray(R.array.legal_categories)

        // Set up ArrayAdapter
        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, legalCategories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Handle item selection
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedCategory = parent.getItemAtPosition(position).toString()
                Toast.makeText(context, "Selected: $selectedCategory", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Optional: handle the case where no item is selected
            }
        }
    }
}
