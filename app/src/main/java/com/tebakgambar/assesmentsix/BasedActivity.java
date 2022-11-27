package com.tebakgambar.assesmentsix;

import android.content.Context;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

public class BasedActivity extends AppCompatActivity {
    private static BasedActivity Instance;
    MediaPlayer mediaPlayer;

    static BasedActivity getInstance(){
        if (Instance == null){
            return Instance = new BasedActivity();
        }
        return Instance;
    }
    public void playAudioFile(Context context, int sampleAudio) {
        mediaPlayer = mediaPlayer.create(context, sampleAudio);
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }
    public void stopAudioFile() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}
