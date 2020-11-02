package com.example.activit_and_hooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onSecondActivity(View view){
        Log.i("INFO", "SECOND ACTIVITY");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

//        Explicit
    }


    private void onIntentFilter(View view){
//        Implicit
        Intent sendingIntent = new Intent();

        sendingIntent.setAction(Intent.ACTION_SEND);
        sendingIntent.putExtra(SecondActivity.EXTRA_MESSAGE, "IMPLICIT INTENT MESSAGE");
        sendingIntent.setType("text/plain"); // MIME


        Intent windowChooser = Intent.createChooser(sendingIntent, "Chose Application");


        if( sendingIntent.resolveActivity( getPackageManager()) != null ) {
            startActivity(windowChooser);
        }
        else {
            Toast.makeText(this, "windowChooser failed.", Toast.LENGTH_SHORT).show();
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button onIntentFilterBtn = (Button) findViewById(R.id.onIntentFilterBtn);
        onIntentFilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onIntentFilter(v);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ACTIVITY_LIFECYCLE", "MainActivity.onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ACTIVITY_LIFECYCLE", "MainActivity.onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ACTIVITY_LIFECYCLE", "MainActivity.onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ACTIVITY_LIFECYCLE", "MainActivity.onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ACTIVITY_LIFECYCLE", "MainActivity.onStop");
    }
}