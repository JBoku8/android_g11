package com.example.email_password_firebase_g11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var singOutButton: Button
    private lateinit var updatePasswordButton: Button
    private lateinit var userDisplayName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        singOutButton = findViewById(R.id.signOutButton)
        updatePasswordButton = findViewById(R.id.updatePasswordButton)
        userDisplayName = findViewById(R.id.userDisplayName)

        singOutButton.setOnClickListener {
            auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        updatePasswordButton.setOnClickListener {
            val intent = Intent(this, UpdatePasswordActivity::class.java)
            startActivity(intent)
//            finish()
        }

        if( auth.currentUser != null ) {
            val displayName = auth.currentUser?.displayName
            userDisplayName.text = displayName
        }

    }
}