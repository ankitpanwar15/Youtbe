package com.proact.ankit.youtbe;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.HashMap;

public class Video extends YouTubeBaseActivity {

    public static final String API_KEY = "AIzaSyBRRT9I09Gbrt2OzTnihi-EkDrVZIYQNL0";
    HashMap<String,String> videoList ;

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        youTubePlayerView = findViewById(R.id.youtube_player_view);
        final String videoName = getIntent().getStringExtra("id");
        createHashMap();
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(videoList.get(videoName));
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youTubePlayerView.initialize(API_KEY,onInitializedListener);
    }

    public void createHashMap(){
        videoList = new HashMap<String, String>();
        videoList.put("video 1","CvvgdXKrd7g");

    }
}
