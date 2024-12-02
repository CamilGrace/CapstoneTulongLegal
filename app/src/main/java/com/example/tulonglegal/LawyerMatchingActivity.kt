package com.example.tulonglegal

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LawyerMatchingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lawyer_matching)

        // Initialize the spinner
        val spinnerLegalCategory = findViewById<Spinner>(R.id.spinnerLegalCategory)

        // List of legal categories
        val categories = listOf("Criminal", "Civil", "Labor", "Immigration", "Family")

        // Set up the spinner with an ArrayAdapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLegalCategory.adapter = adapter

        // Set the item selected listener
        spinnerLegalCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedCategory = parent.getItemAtPosition(position).toString()
                // Handle the selected category
                Toast.makeText(applicationContext, "Selected Category: $selectedCategory", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle the case when no category is selected
                Toast.makeText(applicationContext, "No category selected", Toast.LENGTH_SHORT).show()
            }
        }

        // Optionally handle the Find My Lawyer button click
        val btnFindMyLawyer = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btnFindMyLawyer)
        btnFindMyLawyer.setOnClickListener {
            // Handle the logic when the button is clicked
            Toast.makeText(applicationContext, "Finding a lawyer...", Toast.LENGTH_SHORT).show()
        }
    }
}
