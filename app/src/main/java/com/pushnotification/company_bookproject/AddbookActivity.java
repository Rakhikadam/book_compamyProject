package com.pushnotification.company_bookproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddbookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);
        DBHelper helper = new DBHelper(AddbookActivity.this);
        EditText name = findViewById(R.id.ftext1);
        EditText image = findViewById(R.id.ftext2);
        EditText price = findViewById(R.id.ftext3);
        EditText author = findViewById(R.id.ftext4);
        EditText offer = findViewById(R.id.ftext5);
        Button submit = findViewById(R.id.fsubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name =name.getText().toString();
                String Image =image.getText().toString();
                String Price =price.getText().toString();
                String Author =author.getText().toString();
                String Offer =offer.getText().toString();

                if (name.getText().toString().isEmpty()) {
                    Toast.makeText(AddbookActivity.this, "Empty name is not valid", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (image.getText().toString().isEmpty()) {
                    Toast.makeText(AddbookActivity.this, "Empty image is not valid", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (price.getText().toString().isEmpty()) {
                    Toast.makeText(AddbookActivity.this, "Empty price is not valid", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (author.getText().toString().isEmpty()) {
                    Toast.makeText(AddbookActivity.this, "Empty price is not valid", Toast.LENGTH_SHORT).show();
                    return;
                }

                helper.addbookinfo(Name,Price,Author,Image,Offer);
                Toast.makeText(AddbookActivity.this, "Add Suessfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AddbookActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AddbookActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
}
}