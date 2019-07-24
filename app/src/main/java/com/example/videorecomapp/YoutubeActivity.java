package com.example.videorecomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.Provider;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class YoutubeActivity extends YouTubeBaseActivity
    implements YouTubePlayer.OnInitializedListener {

    private java.lang.String YOUTUBE_API_KEY = "";//please enter your api_key
    private java.lang.String VIDEO_ID = "RWsFs6yTiGQ";
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    YouTubePlayerFragment myYoutubePlayerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
//        standalone 2019.07.23
//        Intent intent = YouTubeStandalonePlayer.createVideoIntent(this,YOUTUBE_API_KEY,VIDEO_ID);
//        startActivity(intent);
        myYoutubePlayerFragment = (YouTubePlayerFragment)getFragmentManager().findFragmentById(R.id.youtubeplayerfragment);
        myYoutubePlayerFragment.initialize(YOUTUBE_API_KEY,this);

    }

    @Override
    public void onInitializationSuccess(Provider provider, final YouTubePlayer player,
                                        boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
            final Button youtubePlayButton = findViewById(R.id.youtube_play_button);
            youtubePlayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    player.play();
                }
            });
        }
    }
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    "There was an error initializing the YouTubePlayer (%1$s)",
                    errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(YOUTUBE_API_KEY, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView)findViewById(R.id.youtubeplayerfragment);
    }

}

