package com.example.selfpromoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button_preview.setOnClickListener {
            onPreviewClicked()
        }

    }

    private fun onPreviewClicked() {
        val contactName = edit_text_contact_name.text.toString()
        val contactNumber = edit_text_contact_number.text.toString()
        val myDisplayName = edit_text_my_display_name.text.toString()
        val includeJunior = check_box_junior.isChecked
        val jobTitle = spinner_job_title.selectedItem?.toString()
        val immediateStart = check_box_immediate_start.isChecked
        val startDate = edit_text_start_date.text.toString()

        // Kotlin string templates
//        val testString = "Contact Name: $contactName, Contact Number: $contactNumber, " +
//                "Display Name: $myDisplayName, Include Junior: $includeJunior, Job Title: $jobTitle, " +
//                "Immediate Start: $immediateStart, Start Date: $startDate"

        // *** To go to another activity!!! ***
        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Contact Name", contactName)
        previewActivityIntent.putExtra("Contact Number", contactNumber)
        previewActivityIntent.putExtra("My Display Name", myDisplayName)
        previewActivityIntent.putExtra("Include Junior", includeJunior)
        previewActivityIntent.putExtra("Job Title", jobTitle)
        previewActivityIntent.putExtra("Immediate Start", immediateStart)
        previewActivityIntent.putExtra("Start Date", startDate)

        startActivity(previewActivityIntent)
    }


}