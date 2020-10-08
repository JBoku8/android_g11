package com.example.guessgameg_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;


    private void generateNumber(){
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }

    public void playGame(View view){
        Log.i("INFO", "PLAY GAME");
        EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        String message;

        if( editTextNumber.getText().toString().isEmpty() ) {
            message = "Please enter the number.";
        }
        else {
            int userNumber = Integer.parseInt(editTextNumber.getText().toString());

            if( userNumber > randomNumber ){
                message = "Try Lower.";
            }
            else if ( userNumber < randomNumber ) {
                message = "Try Higher.";
            }
            else {
                message = "You Won.";
                generateNumber();
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//        Log.i("INFO", "NUMBER " + editTextNumber.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateNumber();
    }
}