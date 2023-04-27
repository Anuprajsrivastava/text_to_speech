package com.example.speechapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class gridlayout extends AppCompatActivity {

        ArrayList<Data> data=new ArrayList<>();
        RecycleAdapter adapter;
        FloatingActionButton floating;
        RecyclerView recyclerView;
        //    MediaPlayer mediaPlayer;





//        @SuppressLint("MissingInflatedId")
        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_gridlayout);
            recyclerView=findViewById(R.id.recylcerview);
            floating=findViewById(R.id.floating);
            recyclerView.setLayoutManager(new GridLayoutManager(gridlayout.this,2));
            data.add(new Data(R.drawable.yes));
            data.add(new Data(R.drawable.no));
            data.add(new Data(R.drawable.help));
            data.add(new Data(R.drawable.please));
            data.add(new Data(R.drawable.sorry));
            data.add(new Data(R.drawable.thankyou));
            data.add(new Data(R.drawable.stop));
            data.add(new Data(R.drawable.welcome));
            data.add(new Data(R.drawable.friends));
            data.add(new Data(R.drawable.time));
            data.add(new Data(R.drawable.beleive));
            data.add(new Data(R.drawable.eat));
            data.add(new Data(R.drawable.drink));



            adapter = new RecycleAdapter(data);
            recyclerView.setAdapter(adapter);
            floating.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(gridlayout.this,texttospeech.class);
                    startActivity(intent);

                }
            });
//        mediaPlayer.start();
        }


    }