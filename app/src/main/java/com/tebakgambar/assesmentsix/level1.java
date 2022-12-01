package com.tebakgambar.assesmentsix;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.CollationElementIterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class level1 extends AppCompatActivity {

    int lvlpage=MainActivity2.level;

    boolean doubleBackToExitPressedOnce = false;

    ImageButton imagebtn;
    Dialog mDialog;
    Button button;
    Context context;
    TextView textView;

    CountDownTimer countDownTimer;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.level1);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.pop);
        final MediaPlayer wrong = MediaPlayer.create(this, R.raw.wrong);
        final MediaPlayer correct = MediaPlayer.create(this, R.raw.correct);

        LinearLayout linearLayout = findViewById(R.id.bgl1);

        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        textView = findViewById(R.id.timer);
        CountDownTimer timer = new CountDownTimer(40000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                textView.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext()
                        ,"Waktu Kamu Sudah Habis",Toast.LENGTH_LONG).show();
                Intent intentLoadNewActivity = new Intent(level1.this, MainActivity.class);
                intentLoadNewActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                MyMediaPlayer.getMediaPlayerInstance().stopAudioFile();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                startActivity(intentLoadNewActivity);
            }
        }.start();

        button = (Button) findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                timer.cancel();
                Intent intentLoadNewActivity = new Intent(level1.this, MainActivity.class);
                intentLoadNewActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                MyMediaPlayer.getMediaPlayerInstance().stopAudioFile();
                startActivity(intentLoadNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        imagebtn = (ImageButton) findViewById(R.id.bantuan1);
        mDialog = new Dialog(this);


        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                mDialog.setContentView(R.layout.hint1);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mDialog.show();
            }
        });
        context = this;
        EditText editText = (EditText) findViewById(R.id.kata);
        Button btn = (Button) findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().toString().equalsIgnoreCase("samudrapasai"))
                {
                    correct.seekTo(0);
                    correct.start();
                    Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.betul);
                    dialog.setCancelable(false);
                    dialog.setCanceledOnTouchOutside(false);
                    timer.cancel();

                    ImageView imageView = dialog.findViewById(R.id.logobetul);
                    TextView textView = dialog.findViewById(R.id.judul);
                    TextView textView1 = dialog.findViewById(R.id.penjelasan);
                    Button dialogButton = dialog.findViewById(R.id.close);
                    Button dialogButton1 = dialog.findViewById(R.id.next);

                    dialogButton1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intentLoadNewActivity = new Intent(level1.this, level2.class);
                            startActivity(intentLoadNewActivity);
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }
                    });

                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intentLoadNewActivity = new Intent(level1.this, MainActivity.class);
                            intentLoadNewActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            MyMediaPlayer.getMediaPlayerInstance().stopAudioFile();
                            startActivity(intentLoadNewActivity);
                            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        }
                    });

                    dialog.show();
                }else{
                    wrong.seekTo(0);
                    wrong.start();
                    Toast.makeText(getApplicationContext()
                            ,"Jawaban kamu salah",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        return;
    }
}