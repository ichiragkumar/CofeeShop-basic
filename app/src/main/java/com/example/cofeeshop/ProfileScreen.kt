package com.example.cofeeshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class ProfileScreen : AppCompatActivity() {
    private lateinit var database: FirebaseDatabase
    private lateinit var dataRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)

        // Initialize Firebase
        database = FirebaseDatabase.getInstance()
        dataRef = database.reference.child("data")
    }

    override fun onResume() {
        super.onResume()
        // Fetch data
        fetchData()
        print("----------------fetch data------++++++++++++++++++")


    }



    private fun fetchData() {
        dataRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.value
                print("----------------------++++++++++++++++++")
                print(data)
                Toast.makeText(this@ProfileScreen, data.toString(), Toast.LENGTH_SHORT).show()
                displayData(data)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle database error
            }
        })
    }


    private fun displayData(data: Any?) {
        findViewById<TextView>(R.id.dataTextView).text = data.toString()
    }

}