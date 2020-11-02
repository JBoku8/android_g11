package com.example.activit_and_hooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.activit_and_hooks.MESSAGE";


    private void onFinishSecondActivity(View view){
        finish();
    }

    private void onFailActivity(View view){
        Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button finishSecondActivityBtn = (Button) findViewById(R.id.finishSecondActivityBtn);

        finishSecondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFailActivity(view);
                onFinishSecondActivity(view);
            }
        });

        Intent receivedIntent = getIntent();
        String message = receivedIntent.getStringExtra(EXTRA_MESSAGE);

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ACTIVITY_LIFECYCLE", "SecondActivity.onDestroy");
    }
}