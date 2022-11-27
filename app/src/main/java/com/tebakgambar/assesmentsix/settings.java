package com.tebakgambar.assesmentsix;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class settings extends AppCompatActivity {

    ImageButton imagebtn;
    Dialog mDialog;
    TextView linkTextView;
    Context context;
    Button button;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_settings);

        button = (Button) findViewById(R.id.unmute);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(settings.this, MainActivity.class);
                MyMediaPlayer.getMediaPlayerInstance().stopAudioFile();
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.mute);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(settings.this, mute.class);
                MyMediaPlayer.getMediaPlayerInstance().stopAudioFile();
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
    @Override
    protected void onUserLeaveHint() {
        MyMediaPlayer.getMediaPlayerInstance().stopAudioFile();
        super.onUserLeaveHint();
    }
    }