package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Intent i;
    public static final int BACKGROUND_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        i = new Intent(this, SecondActivity.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(i, BACKGROUND_CODE);
            }
        });



//        Activity 1 Below:
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        editText = findViewById(R.id.plain_text_input);
//
//        button = findViewById(R.id.button);
//        i = new Intent(this, SecondActivity.class);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String s = editText.getText().toString();
//                i.putExtra("testString", s);
//
//                startActivity(i);
//            }
//        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == BACKGROUND_CODE && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                int imageID = extras.getInt("imageID");

                ConstraintLayout currentLayout = findViewById(R.id.main_activity);
                currentLayout.setBackground(getDrawable(imageID));
            }
        }
    }
}
