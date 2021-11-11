package com.example.selfpromoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

//        *** BAD WAY TO DO IT ***
//        val contactName = intent.getStringExtra("Contact Name")
//        val contactNumber = intent.getStringExtra("Contact Number")
//        val myDisplayName = intent.getStringExtra("My Display Name")
//        val includeJunior = intent.getBooleanExtra("Include Junior",false)
//        val jobTitle = intent.getStringExtra("Job Title")
//        val immediateStart = intent.getBooleanExtra("Immediate Start",false)
//        val startDate = intent.getStringExtra("Start Date")
//
//        val testString = "Contact Name: $contactName, Contact Number: $contactNumber, My display name: $myDisplayName" +
//                ", Include Junior: $includeJunior, Job Title: $jobTitle, Immediate Start: $immediateStart, Start Date: $startDate"
//
//        text_view_message.text = testString

        val message = intent.getSerializableExtra("Message") as Message
        val messagePreviewText = """
            Hi ${message.contactName},
            
            My name is ${message.myDisplayName} and I am ${message.getFullJobDescription()}.
            
            I have a portfolio of apps to demonstrate my technical skills that i can show on request.
            
            I am able to start a new position ${message.getAvailability()}.
            
            Please get in touch if you have any suitable roles for me.
            
            Thanks and best Regards
        """.trimIndent()

    }

}