package com.example.java_and_kotlin_g11

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myPerson = Person("Kotlin", 23)
        val textView = findViewById<TextView>(R.id.textView)

        textView.text = greet(myPerson.getInfo())


        val value = generateNumber();
        val textViewNumber = findViewById<TextView>(R.id.textViewNumber)
        textViewNumber.text = value.toString()
    }

    fun updateNumber(view: View){
        val value = generateNumber();
        val textViewNumber = findViewById<TextView>(R.id.textViewNumber)
        textViewNumber.text = value.toString()

    }


}

fun generateNumber(): Int {
    val rand = Random()
    val value: Int = rand.nextInt(50)
    return  value;
}


fun greet(text: String = "") = "Hi, $text";