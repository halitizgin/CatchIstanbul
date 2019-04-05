package com.halitizgin.catchistanbul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;

public class CompleteActivity extends AppCompatActivity {

    Integer userScore, binaliScore, ekremScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);
        Intent intent = getIntent();
        userScore = intent.getIntExtra("userScore", -1);
        binaliScore = intent.getIntExtra("binaliScore", -1);
        ekremScore = intent.getIntExtra("ekremScore", -1);
        ImageView kazananImage = findViewById(R.id.kazananImage);
        ImageView ikinciImage = findViewById(R.id.ikinciImage);
        ImageView ucuncuImage = findViewById(R.id.ucuncuImage);

        TextView kazananScore = findViewById(R.id.kazananScore);
        TextView ikinciScore = findViewById(R.id.ikinciScore);
        TextView ucuncuScore = findViewById(R.id.ucuncuScore);
        TextView bildiriText = findViewById(R.id.bildiriText);

        if (userScore > binaliScore && userScore > ekremScore)
        {
            kazananImage.setImageResource(R.drawable.user);
            kazananScore.setText(userScore.toString());
            ikinciImage.setImageResource(R.drawable.binali);
            ikinciScore.setText(binaliScore.toString());
            ucuncuImage.setImageResource(R.drawable.ekrem);
            ucuncuScore.setText(ekremScore.toString());

            bildiriText.setText("Tebrikler iki büyük rakibinizin arasından sıyrılarak İstanbul'u fethettiniz. :)");
        }
        else if (binaliScore > userScore && binaliScore > ekremScore)
        {
            kazananImage.setImageResource(R.drawable.binali);
            kazananScore.setText(binaliScore.toString());
            ikinciImage.setImageResource(R.drawable.ekrem);
            ikinciScore.setText(ekremScore.toString());
            ucuncuImage.setImageResource(R.drawable.user);
            ucuncuScore.setText(userScore.toString());

            bildiriText.setText("Rakibiniz Binali Yıldırım İstanbul'u fethetti.");
        }
        else if (ekremScore > userScore && ekremScore > binaliScore)
        {
            kazananImage.setImageResource(R.drawable.ekrem);
            kazananScore.setText(ekremScore.toString());
            ikinciImage.setImageResource(R.drawable.binali);
            ikinciScore.setText(binaliScore.toString());
            ucuncuImage.setImageResource(R.drawable.user);
            ucuncuScore.setText(userScore.toString());

            bildiriText.setText("Rakibiniz Ekrem İmamoğlu İstanbul'u fethetti.");
        }
    }
}
