package com.jinstipiy.sstc

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button // Import for Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //BUTTONS SECTION-------------------------------------

        // I have linked the button on Homescreen using ID
        val button1 = findViewById<Button>(R.id.buttonProfile)

        // OnClickListener for the button
        button1.setOnClickListener {
            // Navigation to sstcPortal
            val intent = Intent(this, SstcPortal::class.java)
            startActivity(intent)
        }

        // For BUTTON 2
        val button2 = findViewById<Button>(R.id.buttonSemTT)
        button2.setOnClickListener {
            val intent = Intent(this, SemTT::class.java)
            startActivity(intent)
        }

        //For BUTTON 3
        val button3 = findViewById<Button>(R.id.buttonNotif)
        button3.setOnClickListener {
            val intent = Intent(this, notif::class.java)
            startActivity(intent)
        }
    }
}
