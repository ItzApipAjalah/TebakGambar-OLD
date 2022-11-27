package com.tebakgambar.assesmentsix;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class mute extends AppCompatActivity {

    ImageButton imagebtn;
    Dialog mDialog;
    TextView linkTextView;
    Context context;
    Button button;

    private AlertDialog.Builder alertDialog;
    private MediaPlayer mediaPlayer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_mute);

        LinearLayout linearLayout = findViewById(R.id.main);

        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();



        imagebtn = (ImageButton) findViewById(R.id.imagebtn);
        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(mute.this, MainActivity2.class);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        imagebtn = findViewById(R.id.exit);
        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialog = new AlertDialog.Builder(mute.this);
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

                alertDialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mute.this, "Kamu Menekan Tombol Tidak", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.setNeutralButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mute.this, "Kamu Menekan Tombol Batal", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog tDialog = alertDialog.create();
                tDialog.show();
            }
        });

        imagebtn = (ImageButton) findViewById(R.id.credit);
        mDialog = new Dialog(this);

        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                mDialog.setContentView(R.layout.ig);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



                mDialog.show();
            }
        });

        imagebtn = (ImageButton) findViewById(R.id.settings);
        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(mute.this, settings.class);
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
