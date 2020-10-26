package com.example.mediaplayerg_11;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    public void play(View view){
        mediaPlayer.start();
    }

    public void pause(View view){
        mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        VideoView videoView = (VideoView) findViewById(R.id.videoView);
//
//        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
//
//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);
//        videoView.start();

        TextView textView = (TextView) findViewById(R.id.textView);

        String greeting  = getString(R.string.customMessage, "G-11");
        textView.setText(greeting);

        mediaPlayer = MediaPlayer.create(this, R.raw.heavy_rain);
    }
}