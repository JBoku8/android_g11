package com.example.email_password_firebase_g11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class UpdatePasswordActivity : AppCompatActivity() {
    private lateinit var goBackButton: Button
    private lateinit var confirmChangeButton: Button
    private lateinit var passwordEditText: EditText
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_password)

        goBackButton = findViewById(R.id.goBackToMainButton)
        confirmChangeButton = findViewById(R.id.confirmPasswordButton)
        passwordEditText = findViewById(R.id.changePwdEditText)
        auth = FirebaseAuth.getInstance()

        goBackButton.setOnClickListener {
            finish()
        }

        confirmChangeButton.setOnClickListener {
            val password: String = passwordEditText.text.toString()
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "გთხოვთ შეიყვანოთ პაროლი", Toast.LENGTH_LONG).show()
            } else {
                auth.currentUser?.updatePassword(password)
                    ?.addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "პაროლი შეიცვალა წარმატებით", Toast.LENGTH_LONG)
                                .show()
                            finish()
                        } else {
                            Toast.makeText(this, "პაროლი არ შეიცვალა", Toast.LENGTH_LONG)
                                .show()
                        }
                    })
            }
        }
    }
}