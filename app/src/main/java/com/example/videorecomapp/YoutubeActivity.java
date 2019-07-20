package com.example.videorecomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class YoutubeActivity extends AppCompatActivity {

    private java.lang.String YOUTUBE_API_KEY = "";//please enter your api_key
    private java.lang.String VIDEO_ID = "RWsFs6yTiGQ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        Intent intent = YouTubeStandalonePlayer.createVideoIntent(this,YOUTUBE_API_KEY,VIDEO_ID);
        startActivity(intent);
    }
}
