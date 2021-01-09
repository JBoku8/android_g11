package com.example.listviewdemo_g11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TechDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tech_detail)

        val selectedTechTitle = findViewById<TextView>(R.id.selectedTechTitle)
        val selectedTechDesc = findViewById<TextView>(R.id.selectedTechDesc)

        val title = intent.getStringExtra(Constants.Selected_Tech_Title)
        val desc = intent.getStringExtra(Constants.Selected_Tech_Desc)

        selectedTechDesc.text = desc;
        selectedTechTitle.text = title;

    }
}