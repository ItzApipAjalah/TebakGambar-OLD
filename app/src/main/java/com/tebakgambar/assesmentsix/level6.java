package com.tebakgambar.assesmentsix;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
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

public class level6 extends AppCompatActivity {

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

        setContentView(R.layout.level6);

        LinearLayout linearLayout = findViewById(R.id.bgl6);

        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.pop);
        final MediaPlayer wrong = MediaPlayer.create(this, R.raw.wrong);
        final MediaPlayer correct = MediaPlayer.create(this, R.raw.correct);
        imagebtn = (ImageButton) findViewById(R.id.bantuan6);
        mDialog = new Dialog(this);

        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(0);
                mp.start();
                mDialog.setContentView(R.layout.hint6);
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
                if(editText.getText().toString().equalsIgnoreCase("raden patah"))
                {
                    correct.seekTo(0);
                    correct.start();
                    Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.betul6);
                    dialog.setCancelable(false);
                    dialog.setCanceledOnTouchOutside(false);

                    ImageView imageView = dialog.findViewById(R.id.logobetul);
                    TextView textView = dialog.findViewById(R.id.judul);
                    TextView textView1 = dialog.findViewById(R.id.penjelasan);
                    Button dialogButton = dialog.findViewById(R.id.close);
                    Button dialogButton1 = dialog.findViewById(R.id.next);

                    dialogButton1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intentLoadNewActivity = new Intent(level6.this, level7.class);
                            startActivity(intentLoadNewActivity);
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }
                    });

                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intentLoadNewActivity = new Intent(level6.this, MainActivity2.class);
                            startActivity(intentLoadNewActivity);
                            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        }
                    });

                    dialog.show();
                }else{
                    wrong.seekTo(0);
                    wrong.start();
                    Toast.makeText(getApplicationContext()
                            ,"Jawaban kamu salah",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}