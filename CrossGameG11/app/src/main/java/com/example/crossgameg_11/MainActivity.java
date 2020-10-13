package com.example.crossgameg_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean isYellowHidden = false;
//  0 - red , 1 - yellow, 2 - empty
    int player = 0;
    int[] gameState = {2,2,2, 2,2,2, 2,2,2};
    int[][] winPositions = {
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}
    };

    boolean gameIsActive = true;

//    public void onImageClick(View view){
//        Log.d("DEBUG", "Image Clicked");
//        ImageView currentImage = (ImageView) view;
//
//        ImageView redImage = (ImageView) findViewById(R.id.red);
//
//
//        if( isYellowHidden ) {
//            currentImage.animate().alpha(1).translationY(0).setDuration(1000);
//
//            redImage.animate().translationY(-1500).setDuration(1000);
//
//            isYellowHidden = false;
//        }
//        else {
//            redImage.setTranslationY(-1500);
//            redImage.animate().alpha(1).translationY(0).setDuration(1000);
//
//            currentImage.animate().alpha(0).translationY(-1500).setDuration(1000);
//            isYellowHidden = true;
//        }
//
////        currentImage.animate().translationY(-1500).setDuration(1000);
//    }

    public void onPlayGame(View view){
        ImageView currentImage = (ImageView) view;

        int tagIndexValue = Integer.parseInt(currentImage.getTag().toString());

        if( gameState[tagIndexValue] == 2 && gameIsActive) {
            gameState[tagIndexValue] = player;

            currentImage.setTranslationY(-2000);
            if( player == 0) {
                player = 1;
                currentImage.setImageResource(R.drawable.yellow);
            }
            else {
                player = 0;
                currentImage.setImageResource(R.drawable.red);
            }
            currentImage.animate().alpha(1).translationY(0).setDuration(300);


            for(int[] winPosition: winPositions){
                if( gameState[winPosition[0]] != 2 && gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]]) {
                    String message;
                    gameIsActive = false;

                    if( player == 0 ) {
                        message = "RED";
                    }
                    else {
                        message = "Yellow";
                    }

                    Toast.makeText(this, "Winner "+message, Toast.LENGTH_SHORT).show();
                }
            }


        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}