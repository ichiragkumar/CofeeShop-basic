package com.example.cofeeshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        setContentView(R.layout.activity_main)

        val todashboard = findViewById<Button>(R.id.toDashboard)

        todashboard.setOnClickListener {
            val intent = Intent(applicationContext, DashboardScreen::class.java)
            startActivity(intent)
        }
    }
}