package com.example.activity_and_intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.activity_and_intents.MESSAGE";
    public final static String EXTRA_NUM_1 = "com.example.activity_and_intents.NUM_1";
    public final static String EXTRA_NUM_2= "com.example.activity_and_intents.NUM_2";


    public final static int REQUEST_SUM = 4;
    public final static int REQUEST_SUB = 3;


    public void onSecondActivityStart(View view){
        Intent secondActivityIntent = new Intent(this, SecondActivity.class);
//        secondActivityIntent.putExtra(EXTRA_MESSAGE, "Main Activity Message");
//        secondActivityIntent.putExtra(EXTRA_NUM_1, 10);
//        secondActivityIntent.putExtra(EXTRA_NUM_2, 200);

        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_MESSAGE, "Main Activity Message");
        bundle.putInt(EXTRA_NUM_1, 100);
        bundle.putInt(EXTRA_NUM_2, 400);

        secondActivityIntent.putExtras(bundle);

//        startActivity(secondActivityIntent);

        startActivityForResult(secondActivityIntent, REQUEST_SUM);

//        Intent Data -> URI
//        Intent Extra

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        HashMap<String, String> myMap = new HashMap<String, String>();
//
//        myMap.put("Georgia", "Tbilisi");
//        myMap.put("England", "London");
//        myMap.put("France", "Paris");
//
//        for(String key:  myMap.keySet()){
//            Log.i("KEY", key + " - " + myMap.get(key));
//        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       try {
           if( requestCode == REQUEST_SUM ) {
               String responseText = data.getStringExtra(SecondActivity.EXTRA_RESPONSE_MESSAGE);
               TextView responseTextView = (TextView) findViewById(R.id.responseTextView);
               responseTextView.setText(responseText);

               if( resultCode == RESULT_OK ) {
                  responseTextView.setTextColor(Color.BLUE);
               }
               else if (resultCode == RESULT_CANCELED ) {
                   responseTextView.setTextColor(Color.RED);
               }
           }
       }
       catch (Exception e) {

       }

//
//        if(requestCode == REQUEST_SUB ) {
//
//        }

    }

    //    HashMap

    /*


    A -> B -> C -> D -> E

//    STACK


    E
    D
    C
    B
    A
     */
}