package com.example.email_password_firebase_g11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class LoginActivity : AppCompatActivity() {
    private lateinit var goBackButton: Button
    private lateinit var signInButton: Button
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var forgotPassword: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        goBackButton = findViewById(R.id.goBackButton)
        signInButton = findViewById(R.id.loginButton)
        emailEditText = findViewById(R.id.emailLoginEditText)
        passwordEditText = findViewById(R.id.passwordLoginEditText)
        forgotPassword = findViewById(R.id.forgotPassword)
        auth = FirebaseAuth.getInstance()


        goBackButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        forgotPassword.setOnClickListener {
            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }

        signInButton.setOnClickListener {
            val email: String = emailEditText.text.toString()
            val password: String = passwordEditText.text.toString()

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "გთხოვთ შეავსოთ ყველა ველი", Toast.LENGTH_LONG).show()
            } else{
             auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
                 if(task.isSuccessful) {
                     Toast.makeText(this, "წარმატებით გაიარეთ ავტორიზაცია", Toast.LENGTH_LONG).show()
                     val intent = Intent(this, MainActivity::class.java)
                     startActivity(intent)
                     finish()
                 }else {
                     val message: String = getString(R.string.failedLoginMessage)
                     Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                 }
             })
            }
        }
    }
}