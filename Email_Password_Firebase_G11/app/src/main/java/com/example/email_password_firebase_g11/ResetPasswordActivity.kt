package com.example.email_password_firebase_g11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordActivity : AppCompatActivity() {
    private lateinit var goBackButton: Button
    private lateinit var confirmResetButton: Button
    private lateinit var emailEdittext: EditText
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        goBackButton = findViewById(R.id.goBackToLogin)
        confirmResetButton = findViewById(R.id.confirmResetButton)
        emailEdittext = findViewById(R.id.emailResetEditText)
        auth = FirebaseAuth.getInstance()


        goBackButton.setOnClickListener {
            finish()
        }

        confirmResetButton.setOnClickListener {
            val email: String = emailEdittext.text.toString()
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "გთხოვთ შეიყვანი თქვენი ელ.ფოსტა", Toast.LENGTH_LONG).show()
            } else {
                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "ლინკი გაიგზავნა ელ.ფოსტაზე", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            Toast.makeText(this, "შეუძლებელია ლინკის გაგზავნა ელ.ფოსტაზე", Toast.LENGTH_LONG)
                                .show()
                        }
                    })
            }
        }
    }
}