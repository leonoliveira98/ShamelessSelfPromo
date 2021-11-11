package com.example.selfpromoapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var messagePreviewText: String

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

        displayMessage()
        setupButton()
    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("Message") as Message
        messagePreviewText = """
                Hi ${message.contactName},
                
                My name is ${message.myDisplayName} and I am ${message.getFullJobDescription()}.
                
                I have a portfolio of apps to demonstrate my technical skills that i can show on request.
                
                I am able to start a new position ${message.getAvailability()}.
                
                Please get in touch if you have any suitable roles for me.
                
                Thanks and best Regards
            """.trimIndent()

        text_view_message.text = messagePreviewText
    }


    private fun setupButton() {

        button_send_message.setOnClickListener {

            // Send Message Intent
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")  // This ensures only SMS apps respond
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }
    }


}