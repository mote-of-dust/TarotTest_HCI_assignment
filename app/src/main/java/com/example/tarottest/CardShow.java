package com.example.tarottest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class CardShow extends AppCompatActivity {

    TextView tstout;
    TextView tstout2;
    Toast yourFate;
    ImageView Card;
    Button returnBut;



    tarotRecord[] deckArray = new tarotRecord[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_show);

        deckArray[0] = new tarotRecord("Cthulhu", "Description: You are doomed", "@drawable/cthulhu");
        deckArray[1] = new tarotRecord("Azathoth", "Description: You are SUPER doomed", "@drawable/azathoth");
        deckArray[2] = new tarotRecord("Yog-Sothoth", "Description: You are doomed", "@drawable/yog");
        deckArray[3] = new tarotRecord("Hastur", "Description: You are doomed", "@drawable/has");
        deckArray[4] = new tarotRecord("Nyarlathotep", "Description: You are doomed", "@drawable/nyarl");
        deckArray[5] = new tarotRecord("Great Old One", "Description: You are doomed", "@drawable/great_old");
        deckArray[6] = new tarotRecord("Nub and Yeb", "Description: You are doomed", "@drawable/nugyeb");
        deckArray[7] = new tarotRecord("The Deep Ones", "Description: You are doomed", "@drawable/deepones");
        deckArray[8] = new tarotRecord("The Nameless Mist", "Description: You are doomed", "@drawable/nameless");
        deckArray[9] = new tarotRecord("Abhoth", "Description: You are doomed", "@drawable/abh");

        Toast yourFate = Toast.makeText(this, "Your fate is sealed...", Toast.LENGTH_LONG);
        ImageView Card = (ImageView) findViewById(R.id.imageView);



        yourFate.show();

        tstout = (TextView) findViewById(R.id.textView);
        tstout2 = (TextView) findViewById(R.id.textView2);

        Intent sender = getIntent();
        int rngValue = sender.getIntExtra("rng", 1);
        int imageResource = getResources().getIdentifier(deckArray[rngValue].imgPath, null, this.getPackageName());
        Card.setImageResource(imageResource);
        tstout.setText(deckArray[rngValue].name);
        tstout2.setText(deckArray[rngValue].description);

        returnBut = (Button) findViewById(R.id.button2);

        returnBut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String result = deckArray[rngValue].name;

                Intent goBack = new Intent(CardShow.this, MainActivity.class);
                goBack.putExtra("Cardname", result);
                startActivity(goBack);
            }
        });
    }
}