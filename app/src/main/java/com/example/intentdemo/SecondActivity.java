package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    ImageView moon, waterfall;
    int imageID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        Intent i = getIntent();

        moon = findViewById(R.id.moon);
        waterfall = findViewById(R.id.waterfall);

        moon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageID = R.drawable.supermoon;
                finish();
            }
        });
        waterfall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageID = R.drawable.waterfall;
                finish();
            }
        });

//        Activity 1 Below
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
//
//        Intent i = getIntent();
//        String s = i.getExtras().getString("testString");
//
//        textView2 = findViewById(R.id.textView2);
//
//        textView2.setText(s);

    }

    @Override
    public void finish() {
        Intent i = new Intent();
        i.putExtra("imageID",imageID);

        setResult(RESULT_OK, i);
        super.finish();
    }
}