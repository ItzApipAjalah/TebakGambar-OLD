package com.tebakgambar.assesmentsix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class caramain extends AppCompatActivity {

    ImageButton imagebtn;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.caramain);

        LinearLayout linearLayout = findViewById(R.id.bg);

        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.pop);

        imagebtn = (ImageButton) findViewById(R.id.rewind);
        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(caramain.this, MainActivity.class);
                intentLoadNewActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                MyMediaPlayer.getMediaPlayerInstance().stopAudioFile();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intentLoadNewActivity = new Intent(caramain.this, MainActivity.class);
        intentLoadNewActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intentLoadNewActivity);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        MyMediaPlayer.getMediaPlayerInstance().stopAudioFile();
    }
}