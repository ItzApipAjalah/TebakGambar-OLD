package com.tebakgambar.assesmentsix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    ImageButton imagebtn;
    Button button;
    public static int level;

    boolean doubleBackToExitPressedOnce = false;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main2);

        LinearLayout linearLayout = findViewById(R.id.main2);

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
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, MainActivity.class);
                intentLoadNewActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                MyMediaPlayer.getMediaPlayerInstance().stopAudioFile();
            }
        });

        button = (Button) findViewById(R.id.level1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level1.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        Button btnlv2 = (Button) findViewById(R.id.level2);
        btnlv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level2.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level3.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level4.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level5.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level6.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level7.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level8.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level9.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level10.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level11.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level12);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level12.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level13);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level13.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level14);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level14.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level15);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level15.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level16);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level16.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level17);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level17.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level18);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level18.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level19);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level19.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.level20);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity2.this, level20.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent intentLoadNewActivity = new Intent(MainActivity2.this, MainActivity.class);
            intentLoadNewActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intentLoadNewActivity);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            MyMediaPlayer.getMediaPlayerInstance().stopAudioFile();
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(getApplicationContext()
                ,"Ketuk Lagi Untuk Keluar",Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 1000);
    }
}