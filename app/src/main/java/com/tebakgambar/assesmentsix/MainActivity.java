package com.tebakgambar.assesmentsix;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton imagebtn;
    Dialog mDialog;
    TextView linkTextView;

    Context context;
    Button button;

    private AlertDialog.Builder alertDialog;
    public MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = findViewById(R.id.main);

        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();



        button = (Button) findViewById(R.id.start);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.pop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity.this, MainActivity2.class);
                intentLoadNewActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = (Button) findViewById(R.id.caramain);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity.this, caramain.class);
                intentLoadNewActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        button = findViewById(R.id.exit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setIcon(R.drawable.ic_baseline_contact_support_24);
                alertDialog.setTitle(R.string.title);
                alertDialog.setMessage(R.string.massege);

                alertDialog.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                        finish();
                    }
                });

                alertDialog.setNegativeButton("Tidak", null);

                alertDialog.setNeutralButton("Batal", null);

                AlertDialog tDialog = alertDialog.create();
                tDialog.show();
            }
        });

        imagebtn = (ImageButton) findViewById(R.id.credit);
        mDialog = new Dialog(this);

        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                mDialog.setContentView(R.layout.popup);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mDialog.show();
            }
        });
        imagebtn = (ImageButton) findViewById(R.id.ig);
        mDialog = new Dialog(this);

        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                mDialog.setContentView(R.layout.ig);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



                mDialog.show();
            }
        });
        MyMediaPlayer.getMediaPlayerInstance().playAudioFile(MainActivity.this, R.raw.backsound);

        button = (Button) findViewById(R.id.settings);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(MainActivity.this, settings.class);
                startActivity(intentLoadNewActivity);
                intentLoadNewActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentLoadNewActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_baseline_contact_support_24)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton("Tidak", null)
                .setNeutralButton("Batal", null)
                .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                        finish();
                    }
                }).create().show();

    }
}
