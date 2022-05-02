package com.example.tarottest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button activityOneButton;
    TextView cardreceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardreceived = (TextView) findViewById(R.id.textView3);

        activityOneButton = (Button)findViewById(R.id.button);

        activityOneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int nextCard = rand.nextInt(10);
                Intent startSecond = new Intent(MainActivity.this, CardShow.class);
                startSecond.putExtra("rng", nextCard);
                startActivity(startSecond);
            }
        });
        Intent receiver = getIntent();
        String cardname = receiver.getStringExtra("Cardname");
        if (cardname != null) {
            cardreceived.setText("Card You got was: " + cardname + ". Better luck next time.");
        }
        else{
            cardreceived.setText(R.string.defaultval);
        }


    }
}