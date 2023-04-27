package com.example.speechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class firstpage extends AppCompatActivity {

    ImageView help,mic;
    TextView helptxt,mictxt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);

        help=findViewById(R.id.help);
        mic=findViewById(R.id.mic);
        helptxt=findViewById(R.id.helptxt);
        mictxt=findViewById(R.id.mictxt);


        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(firstpage.this,gridlayout.class);
                startActivity(intent);
            }
        });
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(firstpage.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}