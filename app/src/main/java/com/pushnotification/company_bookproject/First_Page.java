package com.pushnotification.company_bookproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class First_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        LinearLayout linear = findViewById(R.id.linear);

        /*linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First_Page.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });*/

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //SharedPreferences preferences = getSharedPreferences("MyApp",MODE_PRIVATE);
                Intent intent = new Intent(First_Page.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);

    }


}