package com.example.myfirstapplicationg_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onButtonClick(View view){
//        TextView appTitleTextView = (TextView) findViewById(R.id.appTitleTextView);
//        EditText editTextPersonName = (EditText) findViewById(R.id.editTextPersonName);
//
//
//        appTitleTextView.setText("onButtonClick");
//        Log.i("INFO", "onButtonClick Event");
//
//        Toast.makeText(this, "Hi, " + editTextPersonName.getText().toString(), Toast.LENGTH_SHORT).show();
//        Log.i("USER_INPUT", editTextPersonName.getText().toString());
//

//        TODO Multiple update
    }

    public void onSwitchCatButton(View view){
        Log.i("INFO", "onSwitchCatButton Event");
        ImageView image = (ImageView) findViewById(R.id.switchCatImageView);
        image.setImageResource(R.drawable.cat_1);

//        TODO toggle images
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}