package com.halitizgin.catchistanbul;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int yuzde = 0;
    Handler handler, handler2;
    Runnable runnable, runnable2;
    Integer userScore = 0, binaliScore = 0, ekremScore = 0;
    TextView sandik;
    TextView userScoreText;
    TextView binaliScoreText;
    TextView ekremScoreText;
    ImageView[] istanbullar;
    ImageView istanbul1;
    ImageView istanbul2;
    ImageView istanbul3;
    ImageView istanbul4;
    ImageView istanbul5;
    ImageView istanbul6;
    ImageView istanbul7;
    ImageView istanbul8;
    ImageView istanbul9;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        istanbul1 = findViewById(R.id.istanbul1);
        istanbul2 = findViewById(R.id.istanbul2);
        istanbul3 = findViewById(R.id.istanbul3);
        istanbul4 = findViewById(R.id.istanbul4);
        istanbul5 = findViewById(R.id.istanbul5);
        istanbul6 = findViewById(R.id.istanbul6);
        istanbul7 = findViewById(R.id.istanbul7);
        istanbul8 = findViewById(R.id.istanbul8);
        istanbul9 = findViewById(R.id.istanbul9);

        sandik = findViewById(R.id.sandikText);
        userScoreText = findViewById(R.id.userScoreText);
        binaliScoreText = findViewById(R.id.binaliScoreText);
        ekremScoreText = findViewById(R.id.ekremScoreText);

        sandik.setText("Açılan Sandık Yüzdesi: %" + yuzde);
        istanbullar = new ImageView[] { istanbul1, istanbul2, istanbul3, istanbul4, istanbul5, istanbul6, istanbul7, istanbul8, istanbul9 };

        new CountDownTimer(100000, 1000){
            @Override
            public void onFinish() {
                handler.removeCallbacks(runnable);
                handler2.removeCallbacks(runnable2);

                Intent intent = new Intent(MainActivity.this, CompleteActivity.class);
                intent.putExtra("userScore", userScore);
                intent.putExtra("binaliScore", binaliScore);
                intent.putExtra("ekremScore", ekremScore);
                startActivity(intent);
            }

            @Override
            public void onTick(long millisUntilFinished) {
                yuzde++;
                sandik.setText("Açılan Sandık Yüzdesi: %" + yuzde);
            }
        }.start();

        istanbullarHareket();
        rakipScore();
    }

    public void binaliScore()
    {
        Random random = new Random();
        int bRandom = random.nextInt(100);
        if (bRandom % 2 == 0)
            binaliScore++;
        binaliScoreText.setText(binaliScore.toString());
    }

    public void ekremScore()
    {
        Random random = new Random();
        int bRandom = random.nextInt(100);
        if (bRandom % 2 == 0)
            ekremScore++;
        ekremScoreText.setText(ekremScore.toString());
    }

    public void istanbullariGizle()
    {
        for (ImageView istanbul : istanbullar)
        {
            istanbul.setVisibility(View.INVISIBLE);
        }
    }

    public void istanbulGoster(int position)
    {
        istanbullar[position].setVisibility(View.VISIBLE);
    }

    public void istanbullarHareket()
    {
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                istanbullariGizle();

                Random random = new Random();
                int x = random.nextInt(9);
                istanbulGoster(x);
                handler.postDelayed(this, 500);
            }
        };

        handler.post(runnable);
    }

    public void rakipScore()
    {
        handler2 = new Handler();

        runnable2 = new Runnable() {
            @Override
            public void run() {
                binaliScore();
                ekremScore();
                handler2.postDelayed(this, 300);
            }
        };

        handler2.post(runnable2);
    }

    public void istanbulClick(View view)
    {
        userScore++;
        userScoreText.setText(userScore.toString());
    }
}
