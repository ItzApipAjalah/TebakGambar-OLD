package com.tebakgambar.assesmentsix;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.TextView;

import java.io.IOException;

public class MyMediaPlayer {
    private static MyMediaPlayer Instance;
    private MediaPlayer mediaPlayer;

    private TextView textView;

    static MyMediaPlayer getMediaPlayerInstance() {
        if (Instance == null) {
            return Instance = new MyMediaPlayer();
        }
        return Instance;
    }

    public void playAudioFile(Context context, int sampleAudio) {
        mediaPlayer = MediaPlayer.create(context, sampleAudio);
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                mp.start();
            }
        });

    }

    public void stopAudioFile() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();

        }
    }
}

