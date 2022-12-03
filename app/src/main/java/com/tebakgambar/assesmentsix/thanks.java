package com.tebakgambar.assesmentsix;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class thanks extends AppCompatActivity {

    ImageButton imagebtn;
    Dialog mDialog;
    Button button;
    Context context;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.thanks);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.pop);
        final MediaPlayer wrong = MediaPlayer.create(this, R.raw.wrong);
        final MediaPlayer correct = MediaPlayer.create(this, R.raw.correct);

        button = (Button) findViewById(R.id.blevel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                Intent intentLoadNewActivity = new Intent(thanks.this, bonuslevel.class);
                intentLoadNewActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_baseline_contact_support_24)
                .setTitle("Really Exit?")
                .setMessage("Jika Kamu Keluar Akan Bermain dari awal")
                .setNegativeButton("Tidak", null)
                .setNeutralButton("Batal", null)
                .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intentLoadNewActivity = new Intent(thanks.this, MainActivity.class);
                        intentLoadNewActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        MyMediaPlayer.getMediaPlayerInstance().stopAudioFile();
                        startActivity(intentLoadNewActivity);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }
                }).create().show();
    }
}