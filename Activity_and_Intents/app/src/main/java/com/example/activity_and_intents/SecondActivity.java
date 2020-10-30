package com.example.activity_and_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public final static String EXTRA_RESPONSE_MESSAGE = "com.example.activity_and_intents.RESPONSE_MESSAGE";


    public void onMainActivityStart(View view){
        Intent responseIntent = new Intent();
        responseIntent.putExtra(EXTRA_RESPONSE_MESSAGE, "Response Text.");
        setResult(RESULT_OK, responseIntent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent receivedIntent = getIntent();
        Bundle receivedBundle = receivedIntent.getExtras();

//        String message = receivedIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//        Integer num_1 = receivedIntent.getIntExtra(MainActivity.EXTRA_NUM_1, 0);
//        Integer num_2 = receivedIntent.getIntExtra(MainActivity.EXTRA_NUM_2, 0);

        String message = receivedBundle.getString(MainActivity.EXTRA_MESSAGE);
        Integer num_1 = receivedBundle.getInt(MainActivity.EXTRA_NUM_1, 0);
        Integer num_2 = receivedBundle.getInt(MainActivity.EXTRA_NUM_2, 0);

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(message);


        TextView resultTextView = (TextView)findViewById(R.id.resultTextView);

        resultTextView.setText("Sum is - " + (num_1 + num_2));
    }
}